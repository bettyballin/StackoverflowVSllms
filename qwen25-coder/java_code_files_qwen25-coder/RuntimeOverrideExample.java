import javassist.*;

public class RuntimeOverrideExample {

    public static void main(String[] args) throws Exception {
        // Define class pool and classes
        ClassPool pool = ClassPool.getDefault();
        CtClass overriderClass = pool.get("Overrider");
        CtClass injectorClass = pool.get("Injector");

        // Find the method 'myMethod' in Overrider
        CtMethod originalMethod = overriderClass.getDeclaredMethod("myMethod");

        // Replace its body with a call to Injector.myMethod()
        String newBody = "{ " + injectorClass.getName() + ".myMethod(); }";
        originalMethod.setBody(newBody);

        // Obtain a modified class instance and cast it
        Overrider alteredInstance = (Overrider) overriderClass.toClass().getDeclaredConstructor().newInstance();

        // Test the call
        alteredInstance.myMethod();
    }
}

abstract class MyClass {
    public void myMethod() {}
}

class Overrider extends MyClass {
    @Override
    public void myMethod() {
        System.out.println("Overrider.myMethod()");
    }
}

class Injector {
    public static void myMethod() {
        System.out.println("Injector.myMethod()");
    }
}