import java.util.Arrays;
import java.util.List;

public class AirportNameSuggester {
    private List<String> airportNames;

    public AirportNameSuggester(List<String> airportNames) {
        this.airportNames = airportNames;
    }

    public List<String> suggestAirportNames(String userInput) {
        userInput = userInput.toUpperCase();
        return airportNames.stream()
                .filter(name -> name.startsWith(userInput))
                .toList();
    }

    public static void main(String[] args) {
        List<String> airportNames = Arrays.asList("JFK", "LAX", "ORD", "DFW", "EWR");
        AirportNameSuggester suggester = new AirportNameSuggester(airportNames);

        String userInput = "JFk";
        List<String> suggestions = suggester.suggestAirportNames(userInput);
        System.out.println(suggestions); // [JFK]
    }
}