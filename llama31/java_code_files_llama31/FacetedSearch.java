/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

class FacetedSearch {
    private DistributedSearch search;
    private Map<String, Map<String, Integer>> facetCounts;

    public FacetedSearch(DistributedSearch distributedSearch) {
        this.search = distributedSearch;
        this.facetCounts = new HashMap<String, Map<String, Integer>>();
    }

    public Map<String, Map<String, Integer>> getFacetCounts(String string) {
        return new HashMap<String, Map<String, Integer>>();
    }

    public static void main(String[] stringArray) {
        SearchIndex searchIndex = new SearchIndex();
        DistributedSearch distributedSearch = new DistributedSearch();
        FacetedSearch facetedSearch = new FacetedSearch(distributedSearch);
        facetedSearch.getFacetCounts("example query");
    }
}
