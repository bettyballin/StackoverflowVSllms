import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionSecurityChecker {
    public static void main(String[] args) throws Exception {
        if(args.length == 0) {
            System.out.println("Please provide the class name as an argument.");
            return;
        }

        Class<?> targetClass = Class.forName(args[0]);
        Method[] methods = targetClass.getDeclaredMethods();

        for (Method method : methods) {
            if (!method.isAccessible() && Modifier.isPrivate(method.getModifiers())) {
                // reject execution of private method if not accessible normally
                throw new SecurityException("Not allowed to invoke private method using Reflection API: " + method);
            } else {
                // carry out normal operations here, which could involve executing public methods for instance
            }
        }
    }
}