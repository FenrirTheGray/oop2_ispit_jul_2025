package rs.ac.singidunum.novisad.search;

import java.util.Date;

public class SearchCriteriaFactory {

    public static SearchCriteria<Object> createStringSearch(String fieldName, String value, boolean caseSensitive) {
        return new StringSearchCriteria(fieldName, value, caseSensitive, false);
    }

    public static SearchCriteria<Object> createExactStringSearch(String fieldName, String value, boolean caseSensitive) {
        return new StringSearchCriteria(fieldName, value, caseSensitive, true);
    }

    public static SearchCriteria<Object> createNumericRangeSearch(String fieldName, Double minValue, Double maxValue) {
        return new NumericSearchCriteria(fieldName, minValue, maxValue);
    }

    public static SearchCriteria<Object> createNumericMinSearch(String fieldName, double minValue) {
        return new NumericSearchCriteria(fieldName, minValue, null);
    }

    public static SearchCriteria<Object> createNumericMaxSearch(String fieldName, double maxValue) {
        return new NumericSearchCriteria(fieldName, null, maxValue);
    }

    public static SearchCriteria<Object> createDateRangeSearch(String fieldName, Date fromDate, Date toDate) {
        return new DateSearchCriteria(fieldName, fromDate, toDate);
    }

    public static SearchCriteria<Object> createDateFromSearch(String fieldName, Date fromDate) {
        return new DateSearchCriteria(fieldName, fromDate, null);
    }

    public static SearchCriteria<Object> createDateToSearch(String fieldName, Date toDate) {
        return new DateSearchCriteria(fieldName, null, toDate);
    }
}