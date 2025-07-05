package rs.ac.singidunum.novisad.search;

public interface SearchCriteria<T> {
    boolean matches(T object);
}