import java.util.List;
import java.util.ArrayList;

public class AirportNameSuggester {
    private List<String> airportNames;

    public AirportNameSuggester(List<String> airportNames) {
        this.airportNames = airportNames;
    }

    public List<String> suggestAirportNames(String userInput) {
        List<String> suggestions = new ArrayList<>();

        for (String airportName : airportNames) {
            int distance = levenshteinDistance(userInput, airportName);
            if (distance <= 2) { // adjust the threshold value as needed
                suggestions.add(airportName);
            }
        }

        return suggestions;
    }

    private int levenshteinDistance(String s1, String s2) {
        int[] costs = new int[s2.length() + 1];
        for (int j = 0; j < costs.length; j++) {
            costs[j] = j;
        }
        for (int i = 1; i <= s1.length(); i++) {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= s2.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), s1.charAt(i - 1) == s2.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[s2.length()];
    }

    public static void main(String[] args) {
        List<String> airportNames = new ArrayList<>();
        airportNames.add("New York JFK");
        airportNames.add("Los Angeles LAX");
        airportNames.add("Chicago ORD");
        airportNames.add("Houston IAH");
        airportNames.add("Seattle SEA");

        AirportNameSuggester suggester = new AirportNameSuggester(airportNames);
        List<String> suggestions = suggester.suggestAirportNames("New");

        System.out.println(suggestions);
    }
}