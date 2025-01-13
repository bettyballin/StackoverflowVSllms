import java.io.Serializable;
import java.lang.Thread;

public class Parent_8_8 implements Serializable {
    private String name;

    public Parent_8(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Child extends Parent_8 {
    private transient Thread thread; // Using transient to exclude non-serializable field

    public Child(String name) {
        super(name);
        this.thread = new Thread();
    }

    public static void main(String[] args) {
    }
}