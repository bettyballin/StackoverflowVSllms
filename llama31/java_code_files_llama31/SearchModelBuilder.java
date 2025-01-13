/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class SearchModelBuilder {
    Map<String, Object> model = new HashMap<String, Object>();
    String keywords = "some keywords";

    public SearchModelBuilder() {
        this.model.put("keywords", this.keywords);
    }

    public static void main(String[] stringArray) {
        SearchModelBuilder searchModelBuilder = new SearchModelBuilder();
    }
}
