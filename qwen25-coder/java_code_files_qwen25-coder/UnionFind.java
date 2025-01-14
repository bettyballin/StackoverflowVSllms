import java.util.*;

class Person {
    String ssn;
    String dln;
    // Add other attributes as necessary

    Person(String ssn, String dln) {
        this.ssn = ssn;
        this.dln = dln; // Initialize other attributes similarly
    }

    @Override
    public String toString() {
        return "Person{ssn='" + ssn + "', dln='" + dln + "'}";
    }
}

class UnionFind {
    private Map<String, String> parentSSN = new HashMap<>();
    private Map<String, String> parentDLN = new HashMap<>();

    public void makeSet(Person person) {
        parentSSN.put(person.ssn, person.ssn);
        parentDLN.put(person.dln, person.dln); // Initialize other identifiers similarly
    }

    // Path compression technique
    private String find(Map<String, String> parentMap, String id) {
        if (!parentMap.get(id).equals(id)) {
            parentMap.put(id, find(parentMap, parentMap.get(id)));
        }
        return parentMap.get(id);
    }

    public void union(Person p1, Person p2) {
        String rootSSN1 = find(parentSSN, p1.ssn);
        String rootSSN2 = find(parentSSN, p2.ssn);

        if (!rootSSN1.equals(rootSSN2)) {
            parentSSN.put(rootSSN1, rootSSN2);
        }

        String rootDLN1 = find(parentDLN, p1.dln);
        String rootDLN2 = find(parentDLN, p2.dln);

        if (!rootDLN1.equals(rootDLN2)) {
            parentDLN.put(rootDLN1, rootDLN2);
        }

        // Handle other identifiers similarly
    }

    public Map<String, Set<Person>> getConnectedComponents(List<Person> persons) {
        Map<String, Set<Person>> components = new HashMap<>();

        for (Person p : persons) {
            String rootSSN = find(parentSSN, p.ssn);
            String rootDLN = find(parentDLN, p.dln);

            // Create a unique component identifier using both roots
            String rootID = rootSSN + ":" + rootDLN; // Combine other identifiers as needed

            components.putIfAbsent(rootID, new HashSet<>());
            components.get(rootID).add(p);
        }

        return components;
    }
}

// Usage example:
public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
            new Person("SSN1", "DLN1"),
            new Person("SSN2", "DLN1"),
            new Person("SSN3", "DLN2"),
            new Person("SSN1", "DLN3")
            // Add more persons as needed
        );

        UnionFind uf = new UnionFind();

        for (Person person : persons) {
            uf.makeSet(person);
        }

        // Assume we know all pairs that need to be unioned beforehand or iterate over all to check
        // Here's a simplified example where we manually specify some unions
        uf.union(persons.get(0), persons.get(1));
        uf.union(persons.get(1), persons.get(3));

        Map<String, Set<Person>> result = uf.getConnectedComponents(persons);

        for (Set<Person> component : result.values()) {
            System.out.println(component);
        }
    }
}