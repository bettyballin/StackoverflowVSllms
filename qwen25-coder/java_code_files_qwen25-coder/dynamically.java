public class dynamically {
    public boolean isSubclassOf(String className, Class<?> superClass) {
        try {
            // Load the class dynamically using its name
            Class<?> clazz = Class.forName(className);
            // Check if the loaded class is a subclass of the specified superclass
            return superClass.isAssignableFrom(clazz) && !superClass.equals(clazz);
        } catch (ClassNotFoundException e) {
            // Handle the case where the class name is invalid or not found
            System.err.println("Class " + className + " not found.");
            return false;
        }
    }
    public static void main(String[] args) {
    }
}