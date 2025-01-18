import java.lang.String;
import java.io.*;
public class Main_90 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        Person person = new Person("John", "Smith");

        // Write the object to the output stream.
        oos.writeObject(person);

        // Now convert back from bytes so we can print it out.
        ByteArrayInputStream bais = new ByteArrayInputStream (baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);

        Person personBackFromStream = (Person)ois.readObject();  // <-- Cast back to a 'Person'.
        System.out.println(personBackFromStream);                // <-- Print the object using its toString() method.
    }
}
class Person implements Serializable {   // <-- Must implement the Serializable interface!
    private String firstName;
    private String lastName;
    public Person (String _firstName, String _lastName) {
        this.firstName = _firstName;  this.lastName =_lastName;
    }
    @Override   // <-- Override toString() to return more meaningful string representation of the object.
    public String toString (){return "Person [firstName=" + firstName + ", lastName=" + lastName+"]";}  //<-- Return a 'stringified' form suitable for printing out in console!
}