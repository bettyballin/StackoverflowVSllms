/*
 * Decompiled with CFR 0.152.
 */
public class EfficientDataStructure {
    BalancedBST bbst = new BalancedBST();
    HashTable hashTable = new HashTable();

    public void insert(int n, int n2) {
        this.bbst.insert(n, n2);
        this.hashTable.put(n, n2);
    }

    public void delete(int n) {
        int n2 = this.hashTable.get(n);
        this.bbst.delete(n);
        this.hashTable.remove(n);
    }

    public int getIndex(int n) {
        return this.hashTable.get(n);
    }

    public int getValue(int n) {
        return this.bbst.getValue(n);
    }

    public static void main(String[] stringArray) {
        EfficientDataStructure efficientDataStructure = new EfficientDataStructure();
        efficientDataStructure.insert(10, 0);
        efficientDataStructure.insert(20, 1);
        efficientDataStructure.insert(30, 2);
        System.out.println(efficientDataStructure.getIndex(20));
        System.out.println(efficientDataStructure.getValue(1));
        efficientDataStructure.delete(20);
        System.out.println(efficientDataStructure.getIndex(20));
    }
}
