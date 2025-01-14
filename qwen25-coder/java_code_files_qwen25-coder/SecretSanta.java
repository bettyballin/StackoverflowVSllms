import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SecretSanta {
    private Map<String, List<String>> potentialGiftees;
    private Map<String, String> matches;
    private Set<String> people;

    public SecretSanta(Map<String, List<String>> potentialGiftees) {
        this.potentialGiftees = potentialGiftees;
        this.matches = new HashMap<>();
        this.people = new HashSet<>(potentialGiftees.keySet());
    }

    public boolean findMatches() {
        return backtrack();
    }

    private boolean backtrack() {
        if (people.isEmpty()) return true;

        String person = people.iterator().next();
        List<String> gifteeList = potentialGiftees.get(person);

        for (String giftee : new ArrayList<>(gifteeList)) {
            if (!matches.containsKey(giftee) && !giftee.equals(person)) {
                matches.put(person, giftee);
                people.remove(person);

                boolean result = backtrack();
                if (result) return true;

                // Backtrack
                matches.remove(person);
                people.add(person);
            }
        }

        return false;
    }

    public Map<String, String> getMatches() {
        return matches;
    }

    public static void main(String[] args) {
        // Example configuration
        Map<String, List<String>> disallowedPairs = new HashMap<>();
        disallowedPairs.put("Alice", Arrays.asList("Bob"));
        disallowedPairs.put("Bob", Arrays.asList("Alice"));
        disallowedPairs.put("Charlie", Arrays.asList("David"));
        disallowedPairs.put("David", Arrays.asList("Charlie"));

        // Initialize potential giftees
        Map<String, List<String>> potentialGiftees = new HashMap<>();
        for (String person : disallowedPairs.keySet()) {
            List<String> allOthers = new ArrayList<>(disallowedPairs.keySet());
            allOthers.remove(person);
            allOthers.removeAll(disallowedPairs.getOrDefault(person, Collections.emptyList()));
            potentialGiftees.put(person, allOthers);
        }

        SecretSanta secretSanta = new SecretSanta(potentialGiftees);
        boolean success = secretSanta.findMatches();
        if (success) {
            System.out.println("Matches found: " + secretSanta.getMatches());
        } else {
            System.out.println("No valid matches could be made.");
        }
    }
}