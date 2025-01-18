import java.io.Serializable;

@interface Entity {}
@interface Column {
    String name();
}
@interface Any {
    Column metaColumn();
}

@Entity
public class Customer {
   @Any(metaColumn=@Column(name="type"))
    private ValueObject value;  // A superclass of Varchar, Integer and other classes.
}

abstract class ValueObject implements Serializable {
   protected Long id;
   public abstract String getValue();  // Implement this method in subclasses

   public static void main(String[] args) {
   }
}