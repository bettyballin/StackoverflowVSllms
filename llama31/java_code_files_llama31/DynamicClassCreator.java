/*
 * Decompiled with CFR 0.152.
 */
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class DynamicClassCreator {
    public static void main(String[] stringArray) {
        String string = "MyDynamicClass";
        String string2 = "public class " + string + " { private String myProperty; public String getMyProperty() { return myProperty; } public void setMyProperty(String myProperty) { this.myProperty = myProperty; } }";
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        int n = javaCompiler.run(null, null, null, string, string2);
        if (n == 0) {
            System.out.println("Class created successfully!");
        } else {
            System.out.println("Compilation failed");
        }
    }
}
