import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class StateCache {
    private final static List<String> US_STATES = Arrays.asList(
        "Alabama", "Alaska", "Arizona", "Arkansas", "California",
        // other states...
        " Wyoming"
    );

    public List<String> getStates() {
        return US_STATES;
    }

    public static void main(String[] args) {
    }
}