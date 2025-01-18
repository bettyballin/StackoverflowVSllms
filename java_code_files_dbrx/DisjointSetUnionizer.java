import java.util.*;

public class DisjointSetUnionizer {
    public static void disjointSetUnion(List<String> inputValues, Map<String, String> edgesWithPriorities){
        // Initialize sets for values and a priority queue for the edges
        UnionFind uf = new UnionFind(inputValues);
        PriorityQueue<Relationship> pq = loadPriorityQueue(edgesWithPriorities);

        List<List<String>> paths = new ArrayList<>();

        while(!pq.isEmpty()){
            // Dequeuing highest priority edge (or relationship) one at a time
            Relationship rel = pq.poll();
            UFSet xSet = uf.get(rel.v1);
            UFSet ySet = uf.get(rel.v2);

            if (!xSet.equals(ySet)) {    // If not in the same set already merge them and add corresponding input
                List<String> path = new ArrayList<>();  // Initialize a path
                for ( String val: ySet){               // Add everything from ySet to 'path' list of this disjoint set path
                    if(!xSet.contains(val)){           // avoiding duplicates as they have same root parent node
                        uf.union(rel, xSet.getParent(), ySet.getParent());       // unionize these values into one unique set (highest priority)
                        path.add( val);              // add this value to current path as it's a new one here..
                    }
                }
                paths.add(path);                      // adding a disjoint 'path'
            }
        }
    }

    public static PriorityQueue<Relationship> loadPriorityQueue(Map<String, String> edgesWithPriorities) {
        PriorityQueue<Relationship> pq = new PriorityQueue<>();
        for (Map.Entry<String, String> entry : edgesWithPriorities.entrySet()) {
            String edgeStr = entry.getKey();
            String priorityStr = entry.getValue();

            int priority = Integer.parseInt(priorityStr);

            // Assuming edgeStr is in the form "v1,v2"
            String[] vertices = edgeStr.split(",");
            String v1 = vertices[0];
            String v2 = vertices[1];

            Relationship rel = new Relationship(v1, v2, priority);
            pq.add(rel);
        }
        return pq;
    }

    public static void main(String[] args) {
    }
}

// Additional classes
class Relationship implements Comparable<Relationship> {
    public String v1;
    public String v2;
    public int priority;

    public Relationship(String v1, String v2, int priority) {
        this.v1 = v1;
        this.v2 = v2;
        this.priority = priority;
    }

    @Override
    public int compareTo(Relationship other) {
        // Assuming higher priority value means higher priority
        return Integer.compare(other.priority, this.priority);
    }
}

class UFSet implements Iterable<String> {
    private Set<String> elements;
    private String parent;

    public UFSet(String parent) {
        this.parent = parent;
        elements = new HashSet<>();
        elements.add(parent);
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public boolean contains(String element) {
        return elements.contains(element);
    }

    public void addElement(String element) {
        elements.add(element);
    }

    public Set<String> getElements() {
        return elements;
    }

    @Override
    public Iterator<String> iterator() {
        return elements.iterator();
    }
}

class UnionFind {
    private Map<String, UFSet> nodeToSet;

    public UnionFind(List<String> elements) {
        nodeToSet = new HashMap<>();
        for (String elem : elements) {
            UFSet set = new UFSet(elem);
            nodeToSet.put(elem, set);
        }
    }

    public UFSet get(String s) {
        return nodeToSet.get(s);
    }

    public void union(Relationship rel, String parent1, String parent2) {
        UFSet set1 = nodeToSet.get(parent1);
        UFSet set2 = nodeToSet.get(parent2);

        if (set1 != set2) { // Merge the two sets
            // Merge elements of set2 into set1
            for (String elem : set2.getElements()) {
                set1.addElement(elem);
                nodeToSet.put(elem, set1);
            }

            // Optionally, update the parent
            set1.setParent(rel.v1);

            // Clear set2
            set2.getElements().clear();
        }
    }
}