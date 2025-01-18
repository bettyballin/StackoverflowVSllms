import java.util.*;

// Define a class for person which will hold their IDs like SSN, DLN, etc.
class Person {
    private String ssn;
    // add other id fields...

    // Constructor
    public Person(String ssn) {
        this.ssn = ssn;
    }

    // Getter
    public String getSsn() {
        return ssn;
    }

    // Method to check if two persons are connected based on SSN
    public boolean isConnectedTo(Person other) {
        // Implement logic to check if this person is connected to 'other' based on SSN, DLN, etc.
        // For example:
        return this.ssn.equals(other.ssn);
    }
}

// Class representing an item in the Union-Find data structure
class Item {
    private Person person;

    public Item(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public boolean isConnectedTo(Person otherPerson) {
        return person.isConnectedTo(otherPerson);
    }
}

// Union-Find (Disjoint Set Union) data structure implementation
class UnionFind implements Iterable<Item> {
    private Map<Item, Item> parent = new HashMap<>();
    private Map<Item, Integer> rank = new HashMap<>();
    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        parent.put(item, item);
        rank.put(item, 0);
        items.add(item);
    }

    public Item find(Item item) {
        if (parent.get(item) != item) {
            parent.put(item, find(parent.get(item)));
        }
        return parent.get(item);
    }

    public Set<Person> union(Item item1, Item item2) {
        Item root1 = find(item1);
        Item root2 = find(item2);

        if (root1 == root2) {
            // They are already in the same set
            Set<Person> resultSet = new HashSet<>();
            resultSet.add(item1.getPerson());
            resultSet.add(item2.getPerson());
            return resultSet;
        }

        // Union by rank
        if (rank.get(root1) < rank.get(root2)) {
            parent.put(root1, root2);
        } else if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {
            parent.put(root2, root1);
            rank.put(root1, rank.get(root1) + 1);
        }

        // Return the merged set
        Set<Person> resultSet = new HashSet<>();
        resultSet.add(item1.getPerson());
        resultSet.add(item2.getPerson());
        return resultSet;
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }
}

public class MainClass {
    // Method to return the master sets of people
    public Map<Long, Set<Person>> getMasterSets(List<Person> persons) {
        // Disjoint set data structure instance
        UnionFind dataStructure = new UnionFind();

        // For each Person create an item in dataStructure initially separate from each other
        Map<Person, Item> personItemMap = new HashMap<>();
        for (Person person : persons) {
            Item itemToAdd = initializeItemFrom(person);
            dataStructure.add(itemToAdd);
            personItemMap.put(person, itemToAdd);
        }

        // Method/Loop to find intersecting sets using SSN, DLN or other attributes.
        Map<Item, Set<Person>> tempMasterSets = new HashMap<>();
        for (int i = 0; i < persons.size(); i++) {
            Person personI = persons.get(i);
            Item itemI = personItemMap.get(personI);
            for (Item itemJ : dataStructure) { // this loop assumes you use a suitable collection type that exposes its elements for iteration
                if (!itemJ.isConnectedTo(personI)) { // assuming method is there to check whether two 'Persons' share common id(s).
                    continue;  // skip ahead, no need to merge this set with the i-th person.
                }

                Set<Person> masterSet = dataStructure.union(itemJ, itemI);  // union method handles merges and returns merged set.
                // assuming you want unique lists of Persons under each 'root'
                Item root = dataStructure.find(itemI);  // get the root representative
                if (tempMasterSets.get(root) == null) {
                    tempMasterSets.put(root, masterSet);
                } else {
                    Set<Person> existing = tempMasterSets.get(root);
                    for (Person p : masterSet) {
                        if (!existing.contains(p)) {
                            existing.add(p);
                        }
                    }
                }
            }  // end For Each item J loop
        }

        // Now, map root Items to Long IDs
        Map<Long, Set<Person>> masterSets = new HashMap<>();
        Map<Item, Long> rootIdMap = new HashMap<>();
        long idCounter = 1;
        for (Item root : tempMasterSets.keySet()) {
            rootIdMap.put(root, idCounter++);
            masterSets.put(rootIdMap.get(root), tempMasterSets.get(root));
        }

        return masterSets;
    }

    private Item initializeItemFrom(Person person) {
        return new Item(person);
    }

    public static void main(String[] args) {
        // Example usage
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("123-45-6789"));
        persons.add(new Person("987-65-4321"));
        persons.add(new Person("123-45-6789")); // Duplicate SSN

        MainClass main = new MainClass();
        Map<Long, Set<Person>> masterSets = main.getMasterSets(persons);

        // Output the master sets
        for (Map.Entry<Long, Set<Person>> entry : masterSets.entrySet()) {
            System.out.println("Root ID: " + entry.getKey());
            for (Person p : entry.getValue()) {
                System.out.println("Person SSN: " + p.getSsn());
            }
            System.out.println();
        }
    }
}