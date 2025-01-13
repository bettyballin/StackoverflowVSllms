import java.lang.String;

public class MyLegacyClass {
    private final String jndiName;

    public MyLegacyClass(String jndiName) {
        this.jndiName = jndiName;
    }

    public Object doSomeLegacyStuff(Object legacyObj) {
        // do stuff using jndiName
        return null; // Add a return statement to make the code compile
    }

    public static void main(String[] args) {
        // Add a constructor call to make the code executable
        MyLegacyClass myLegacyClass = new MyLegacyClass("someJndiName");
        myLegacyClass.doSomeLegacyStuff(null);
    }
}

// The following classes were not defined in the original code, so we define them here
class SomeLegacyClass {}
class SomeOtherLegacyClass {}