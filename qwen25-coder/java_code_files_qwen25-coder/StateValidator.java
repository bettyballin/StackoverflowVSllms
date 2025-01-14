import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class StateValidator {
    public boolean isValidState(String stateAbbreviation, int countryId) {
        List<Map<String, String>> states = getStates(countryId);
        for (Map<String, String> state : states) {
            if (state.get("abbreviation").equalsIgnoreCase(stateAbbreviation)) {
                return true;
            }
        }
        return false;
    }

    private List<Map<String, String>> getStates(int countryId) {
        // Dummy implementation
        return new ArrayList<Map<String, String>>();
    }

    public static void main(String[] args) {
    }
}