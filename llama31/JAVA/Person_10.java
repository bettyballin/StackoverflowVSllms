import java.lang.String;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile("example.db4o");

        Person person = new Person("John Doe", 30);
        db.store(person);

        ObjectSet<Person> result = db.query(Person.class);
        for (Person p : result) {
            System.out.println(p.getName() + ", " + p.getAge());
        }

        db.close();
    }
}