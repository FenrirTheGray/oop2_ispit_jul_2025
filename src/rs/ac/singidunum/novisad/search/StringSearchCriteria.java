package rs.ac.singidunum.novisad.search;

import java.lang.reflect.Field;

public class StringSearchCriteria implements SearchCriteria<Object> {
    private String fieldName;
    private String searchValue;
    private boolean caseSensitive;
    private boolean exactMatch;

    public StringSearchCriteria(String fieldName, String searchValue, boolean caseSensitive, boolean exactMatch) {
        this.fieldName = fieldName;
        this.searchValue = searchValue;
        this.caseSensitive = caseSensitive;
        this.exactMatch = exactMatch;
    }

    @Override
    public boolean matches(Object object) {
        try {
            String fieldValue = getFieldValue(object);
            if (fieldValue == null) return false;

            if (!caseSensitive) {
                fieldValue = fieldValue.toLowerCase();
                searchValue = searchValue.toLowerCase();
            }

            if (exactMatch) {
                return fieldValue.equals(searchValue);
            } else {
                return fieldValue.contains(searchValue);
            }
        } catch (Exception e) {
            return false;
        }
    }

    private String getFieldValue(Object object) throws IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = object.getClass();
        
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(object);
            return value != null ? value.toString() : null;
        } catch (NoSuchFieldException e) {
            Class<?> superClass = clazz.getSuperclass();
            while (superClass != null) {
                try {
                    Field field = superClass.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    Object value = field.get(object);
                    return value != null ? value.toString() : null;
                } catch (NoSuchFieldException ex) {
                    superClass = superClass.getSuperclass();
                }
            }
            throw e;
        }
    }
}