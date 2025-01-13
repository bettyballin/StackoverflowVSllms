import java.lang.String;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;

public class DynamicClassCreator_1_1 {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("MyDynamicClass");

        CtField field = new CtField(pool.get("java.lang.String"), "myProperty", ctClass);
        ctClass.addField(field);

        CtMethod getter = CtMethod.make("public String getMyProperty() { return myProperty; }", ctClass);
        CtMethod setter = CtMethod.make("public void setMyProperty(String myProperty) { this.myProperty = myProperty; }", ctClass);

        ctClass.addMethod(getter);
        ctClass.addMethod(setter);

        Class<?> clazz = ctClass.toClass();
        System.out.println("Class created successfully!");
    }
}