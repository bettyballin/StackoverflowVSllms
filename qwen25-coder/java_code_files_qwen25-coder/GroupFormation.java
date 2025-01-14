import java.util.*;

class Person {
    String name;
    Set<String> preferredPartners; // Store names of preferred partners

    public Person(String name) {
        this.name = name;
        this.preferredPartners = new HashSet<>();
    }

    void addPreferredPartner(String partnerName) {
        preferredPartners.add(partnerName);
    }
}

public class GroupFormation {
    Map<String, Person> groupA = new HashMap<>();
    Map<String, Person> groupB = new HashMap<>();
    Map<String, Person> groupC = new HashMap<>();

    Set<Triple> resultGroups = new HashSet<>(); // Store the formed groups

    void addPerson(String name, String groupName) {
        Person person = new Person(name);
        if (groupName.equals("A")) groupA.put(name, person);
        else if (groupName.equals("B")) groupB.put(name, person);
        else if (groupName.equals("C")) groupC.put(name, person);
    }

    void addPreference(String nameA, String nameInOtherGroup, Map<String, Person> otherGroup) {
        groupA.get(nameA).addPreferredPartner(otherGroup.get(nameInOtherGroup).name);
        otherGroup.get(nameInOtherGroup).addPreferredPartner(groupA.get(nameA).name); // Mutual agreement
    }

    boolean isMutuallyPreferred(Person a, Person b) {
        return a.preferredPartners.contains(b.name) && b.preferredPartners.contains(a.name);
    }

    void backtrack() {
        List<Triple> currentCandidate = new ArrayList<>();
        List<Person> listA = new ArrayList<>(groupA.values());
        helper(listA.listIterator(), groupB, groupC, currentCandidate);
    }

    private void helper(ListIterator<Person> iteratorA, Map<String, Person> groupB, Map<String, Person> groupC,
                       List<Triple> currentCandidate) {
        if (!iteratorA.hasNext()) {
            // Evaluate and compare with the best result
            if (currentCandidate.size() > resultGroups.size())
                resultGroups = new HashSet<>(currentCandidate);
            return;
        }

        Person personA = iteratorA.next();
        boolean matchFound = false;

        for (String nameB : personA.preferredPartners) {
            if (!groupB.containsKey(nameB)) continue; // Check existence in current state
            Person personB = groupB.get(nameB);

            for (String nameC : personB.preferredPartners) {
                if (!groupC.containsKey(nameC)) continue;
                Person personC = groupC.get(nameC);

                if (!currentCandidate.stream().anyMatch(t -> t.involves(personB.name) || t.involves(personC.name))
                    && isMutuallyPreferred(personA, personC)) { // Check mutual preference
                    currentCandidate.add(new Triple(personA.name, personB.name, personC.name));

                    Map<String, Person> newGroupB = new HashMap<>(groupB);
                    Map<String, Person> newGroupC = new HashMap<>(groupC);

                    newGroupB.remove(nameB); // Temporary removal
                    newGroupC.remove(nameC);

                    helper(iteratorA, newGroupB, newGroupC, currentCandidate);

                    matchFound = true;

                    // Backtrack
                    currentCandidate.remove(currentCandidate.size() - 1);
                }
            }
        }

        if (!matchFound) {
            iteratorA.previous();
            helper(iteratorA, groupB, groupC, currentCandidate); // Continue without personA in this path
        }
    }

    static class Triple {
        String a;
        String b;
        String c;

        public Triple(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        boolean involves(String name) {
            return a.equals(name) || b.equals(name) || c.equals(name);
        }
    }

    public static void main(String[] args) {
    }
}