import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

// Serialization
class Person_4 implements java.io.Serializable {
    private String name;
    private int age;

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// Marshaling
class Person implements java.io.Serializable {
    private String name;
    private int age;

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // marshaling-specific methods
    public void marshal(DataOutputStream out) throws IOException {
        out.writeUTF(name);
        out.writeInt(age);
    }

    public static Person unmarshal(DataInputStream in) throws IOException {
        Person person = new Person();
        person.name = in.readUTF();
        person.age = in.readInt();
        return person;
    }

    public static void main(String[] args) {
    }
}