public class ObjectRetriever_1_1 {
    public Object getNonNullObject(int i) {
        // ...
        return new Object(); // Return a non-null object
    }

    public Object getNullableObject(int i) {
        // ...
        return null; // Return a nullable object
    }

    public static void main(String[] args) {
        ObjectRetriever_1 retriever = new ObjectRetriever_1();
        System.out.println(retriever.getNonNullObject(1));
        System.out.println(retriever.getNullableObject(1));
    }
}