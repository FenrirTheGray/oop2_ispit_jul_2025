package rs.ac.singidunum.novisad.search;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Search criteria for date fields
 */
public class DateSearchCriteria implements SearchCriteria<Object> {
    private String fieldName;
    private Date fromDate;
    private Date toDate;
    private boolean hasFromDate;
    private boolean hasToDate;

    public DateSearchCriteria(String fieldName, Date fromDate, Date toDate) {
        this.fieldName = fieldName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.hasFromDate = fromDate != null;
        this.hasToDate = toDate != null;
    }

    @Override
    public boolean matches(Object object) {
        try {
            Date fieldValue = getFieldValue(object);
            if (fieldValue == null) return false;

            if (hasFromDate && fieldValue.before(fromDate)) return false;
            if (hasToDate && fieldValue.after(toDate)) return false;

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Date getFieldValue(Object object) throws IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = object.getClass();

        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(object);
            return (Date) value;
        } catch (NoSuchFieldException e) {
            Class<?> superClass = clazz.getSuperclass();
            while (superClass != null) {
                try {
                    Field field = superClass.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    Object value = field.get(object);
                    return (Date) value;
                } catch (NoSuchFieldException ex) {
                    superClass = superClass.getSuperclass();
                }
            }
            throw e;
        }
    }
}