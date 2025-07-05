package rs.ac.singidunum.novisad.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService<T> {
    private List<T> objects;
    private List<SearchCriteria<Object>> criteria;

    public SearchService(List<T> objects) {
        this.objects = objects;
        this.criteria = new ArrayList<>();
    }

    public SearchService<T> addCriteria(SearchCriteria<Object> criterion) {
        criteria.add(criterion);
        return this;
    }

    public List<T> search() {
        return objects.stream()
                .filter(obj -> criteria.stream().allMatch(criterion -> criterion.matches(obj)))
                .collect(Collectors.toList());
    }

    public void clearCriteria() {
        criteria.clear();
    }

    public boolean hasCriteria() {
        return !criteria.isEmpty();
    }

    public int getCriteriaCount() {
        return criteria.size();
    }
}