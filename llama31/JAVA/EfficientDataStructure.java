import java.util.HashMap;

class Node {
    int value;
    int index;
    Node left;
    Node right;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class BalancedBST {
    Node root;

    public void insert(int value, int index) {
        // Insert into BBST
        root = insert(root, value, index);
    }

    public void delete(int value) {
        // Delete from BBST
        root = delete(root, value);
    }

    public int getIndex(int value) {
        // Search for value in BBST and return index
        return getIndex(root, value);
    }

    private Node insert(Node node, int value, int index) {
        if (node == null) {
            return new Node(value, index);
        }
        if (value < node.value) {
            node.left = insert(node.left, value, index);
        } else if (value > node.value) {
            node.right = insert(node.right, value, index);
        }
        return node;
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            node.value = temp.value;
            node.right = delete(node.right, temp.value);
        }
        return node;
    }

    private int getIndex(Node node, int value) {
        if (node == null) {
            return -1;
        }
        if (value < node.value) {
            return getIndex(node.left, value);
        } else if (value > node.value) {
            return getIndex(node.right, value);
        } else {
            return node.index;
        }
    }

    public int getValue(int index) {
        // Traverse BBST to get value at given index
        return getValue(root, index);
    }

    private int getValue(Node node, int index) {
        if (node == null) {
            return -1;
        }
        if (node.index == index) {
            return node.value;
        }
        int leftValue = getValue(node.left, index);
        if (leftValue != -1) {
            return leftValue;
        }
        return getValue(node.right, index);
    }
}

class HashTable {
    HashMap<Integer, Integer> indexValueMap;

    public HashTable() {
        indexValueMap = new HashMap<>();
    }

    public void put(int value, int index) {
        indexValueMap.put(value, index);
    }

    public int get(int value) {
        return indexValueMap.getOrDefault(value, -1);
    }

    public void remove(int value) {
        indexValueMap.remove(value);
    }
}

public class EfficientDataStructure {
    BalancedBST bbst;
    HashTable hashTable;

    public EfficientDataStructure() {
        bbst = new BalancedBST();
        hashTable = new HashTable();
    }

    public void insert(int value, int index) {
        bbst.insert(value, index);
        hashTable.put(value, index);
    }

    public void delete(int value) {
        int index = hashTable.get(value);
        bbst.delete(value);
        hashTable.remove(value);
    }

    public int getIndex(int value) {
        return hashTable.get(value);
    }

    public int getValue(int index) {
        // Traverse BBST to get value at given index
        return bbst.getValue(index);
    }

    public static void main(String[] args) {
        EfficientDataStructure dataStructure = new EfficientDataStructure();
        dataStructure.insert(10, 0);
        dataStructure.insert(20, 1);
        dataStructure.insert(30, 2);
        System.out.println(dataStructure.getIndex(20)); // Output: 1
        System.out.println(dataStructure.getValue(1)); // Output: 20
        dataStructure.delete(20);
        System.out.println(dataStructure.getIndex(20)); // Output: -1
    }
}