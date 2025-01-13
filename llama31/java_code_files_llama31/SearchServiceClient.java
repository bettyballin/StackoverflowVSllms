/*
 * Decompiled with CFR 0.152.
 */
public class SearchServiceClient {
    public static void main(String[] stringArray) {
        SearchServiceClient searchServiceClient = new SearchServiceClient();
        searchServiceClient.search();
    }

    public void search() {
        SearchPort searchPort = new SearchPort();
        SearchResponse searchResponse = (SearchResponse)searchPort.search("Toyota");
        System.out.println(searchResponse);
    }
}
