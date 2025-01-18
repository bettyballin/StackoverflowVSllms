public class LinkedListInsert {

    static class Node {
        int data;
        Node nextPointer;
    }

    public static void main(String[] args) {
        Node startNode = new Node(); // initialize start node

        int value = 42; // set the value to insert

        Node listNode = new Node(); // create a node to be inserted
        listNode.data = value; // set data in the node
        listNode.nextPointer = startNode.nextPointer; // setting up next pointer if not empty list
        startNode.nextPointer = listNode; // pointing the start node to new one

        // Optional: print the list to verify insertion
        Node current = startNode.nextPointer;
        while (current != null) {
            System.out.println(current.data);
            current = current.nextPointer;
        }
    }
}