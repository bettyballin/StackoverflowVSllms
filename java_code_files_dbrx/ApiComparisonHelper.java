import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class ApiComparisonHelper {
    // Building your own API vs using Google's APIs:

    // 1. Own API: Pros & Cons
    Map<String, Object> ownApi = new HashMap<>();
    Map<String, Object> googleApi = new HashMap<>();

    {
        ownApi.put("Pros", Arrays.asList(
            "Full control over functionality and customization.",
            "No limits or quotas imposed by an external service.",
            "Privacy and potential to monetize."));
        ownApi.put("Cons",  Arrays.asList(
            "Requires development and maintenance resources.",
            "Potential legal risks when dealing with data privacy & security regulation.",
            "Lack of expertise in building specific services."));

        // 2. Google API: Pros & Cons
        googleApi.put("Pros", Arrays.asList(
            "Saved time and development resources by using established APIs.",
            "Expert support and potential collaboration opportunities.",
            "More robust infrastructures leading to higher availability."));
        googleApi.put("Cons",  Arrays.asList(
            "Limited customization, sometimes not possible for specific use cases.",
            "Quotas imposed by Google restricting the volume of requests you can make.",
            "Possibility that API is deprecated or features removed with new updates."));
     }

     public static void main(String[] args) {
     }
}