import java.lang.reflect.*;

class MainClass {
}

public class MethodParameterAnalyzer {
    static Class<?> classType = MainClass.class;
    static Method[] methods = classType.getDeclaredMethods(); //Getting all the methods declared within the given class

    static {
        for(Method method : methods){
            Class<?>[] paramTypes = method.getParameterTypes(); // Get an array of types for each parameter
        }
    }

    public static void main(String[] args) {
    }
}