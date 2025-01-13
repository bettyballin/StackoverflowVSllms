// A simple OT implementation in Java
public class OperationalTransformation {
  private String document;

  public OperationalTransformation(String document) {
    this.document = document;
  }

  public void applyOperation(Operation op) {
    // Apply the operation to the document
    document = op.apply(document);
  }

  public Operation transform(Operation op1, Operation op2) {
    // Transform op1 against op2
    return op1.transform(op2);
  }

  public static class Operation {
    private String type; // insert, delete, etc.
    private int position;
    private String text;

    public Operation(String type, int position, String text) {
      this.type = type;
      this.position = position;
      this.text = text;
    }

    public String apply(String document) {
      // Apply the operation to the document
      if (type.equals("insert")) {
        return document.substring(0, position) + text + document.substring(position);
      } else if (type.equals("delete")) {
        return document.substring(0, position) + document.substring(position + text.length());
      }
      return document; // default case
    }

    public Operation transform(Operation other) {
      // Transform this operation against the other operation
      if (type.equals("insert") && other.type.equals("insert")) {
        // Handle insert-insert transformation
        if (position <= other.position) {
          return new Operation("insert", position, text);
        } else {
          return new Operation("insert", position + other.text.length(), text);
        }
      } else if (type.equals("insert") && other.type.equals("delete")) {
        // Handle insert-delete transformation
        if (position <= other.position) {
          return new Operation("insert", position, text);
        } else {
          return new Operation("insert", position - other.text.length(), text);
        }
      } else if (type.equals("delete") && other.type.equals("insert")) {
        // Handle delete-insert transformation
        if (position <= other.position) {
          return new Operation("delete", position, text);
        } else {
          return new Operation("delete", position + other.text.length(), text);
        }
      } else if (type.equals("delete") && other.type.equals("delete")) {
        // Handle delete-delete transformation
        if (position <= other.position) {
          return new Operation("delete", position, text);
        } else {
          return new Operation("delete", position - other.text.length(), text);
        }
      }
      return this; // default case
    }
  }

  public static void main(String[] args) {
    OperationalTransformation ot = new OperationalTransformation("Hello World");
    Operation op1 = new Operation("insert", 6, " Beautiful");
    Operation op2 = new Operation("delete", 0, "H");

    ot.applyOperation(op1);
    System.out.println(ot.document); // Output: "Hello Beautiful World"

    ot.applyOperation(op2);
    System.out.println(ot.document); // Output: "ello Beautiful World"

    Operation transformedOp = ot.transform(op1, op2);
    System.out.println(transformedOp.type + " " + transformedOp.position + " " + transformedOp.text);
  }
}