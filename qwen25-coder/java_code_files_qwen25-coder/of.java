import java.lang.String;

public class of {
    public static void main(String[] args) {
        Object object = new SomeClass();
        Class<?> clazz = object.getClass();
        if (YourInterface.class.isAssignableFrom(clazz)) {
            // The class of the object implements YourInterface or extends a class that implements it
        }
    }
}

interface YourInterface { }

class SomeClass implements YourInterface { }