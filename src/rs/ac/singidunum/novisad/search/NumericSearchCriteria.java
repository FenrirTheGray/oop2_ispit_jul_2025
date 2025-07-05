package rs.ac.singidunum.novisad.search;

import java.lang.reflect.Field;

public class NumericSearchCriteria implements SearchCriteria<Object> {
    private String fieldName;
    private double minValue;
    private double maxValue;
    private boolean hasMinValue;
    private boolean hasMaxValue;

    public NumericSearchCriteria(String fieldName, Double minValue, Double maxValue) {
        this.fieldName = fieldName;
        this.minValue = minValue != null ? minValue : Double.MIN_VALUE;
        this.maxValue = maxValue != null ? maxValue : Double.MAX_VALUE;
        this.hasMinValue = minValue != null;
        this.hasMaxValue = maxValue != null;
    }

    @Override
    public boolean matches(Object object) {
        try {
            Number fieldValue = getFieldValue(object);
            if (fieldValue == null) return false;

            double value = fieldValue.doubleValue();

            if (hasMinValue && value < minValue) return false;
            if (hasMaxValue && value > maxValue) return false;

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Number getFieldValue(Object object) throws IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = object.getClass();

        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(object);
            return (Number) value;
        } catch (NoSuchFieldException e) {
            Class<?> superClass = clazz.getSuperclass();
            while (superClass != null) {
                try {
                    Field field = superClass.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    Object value = field.get(object);
                    return (Number) value;
                } catch (NoSuchFieldException ex) {
                    superClass = superClass.getSuperclass();
                }
            }
            throw e;
        }
    }
}