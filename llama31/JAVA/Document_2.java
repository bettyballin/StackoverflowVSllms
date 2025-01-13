// Define the Printable interface
interface Printable {
    void print();
}

// Class implementing the Printable interface
public class Document_2_2 implements Printable {
    @Override
    public void print() {
        System.out.println("Printing a document...");
    }

    public static void main(String[] args) {
        // Create an instance of Document_2 and call the print method
        Document_2 document = new Document_2();
        document.print();
    }
}