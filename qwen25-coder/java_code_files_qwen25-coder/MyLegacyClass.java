public class MyLegacyClass {
    // Making jndiName not final and accessible via constructor or setter if needed later
    private static String jndiName = "java:comp/env/jdbc/LegacyDataSource";

    public static void setJndiName(String name) {
        jndiName = name;
    }

    public SomeLegacyClass doSomeLegacyStuff(SomeOtherLegacyClass legacyObj, String jndiName) {
        // Use the passed jndiName
        return null; // Added return statement to satisfy method return type
    }

    // Alternatively, use a constructor or setter to pass jndiName if it's commonly used

    public static void main(String[] args) {
    }
}

class SomeLegacyClass {
}

class SomeOtherLegacyClass {
}