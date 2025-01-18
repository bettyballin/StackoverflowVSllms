import java.io.*;
import java.lang.reflect.*;

import org.apache.bcel.Const;
import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;
import org.apache.bcel.util.*;

public abstract class MyClass {
    public void myMethod() {}
}

class Overrider extends MyClass {
    @Override
    public void myMethod() {}
}

class Injector {
    public static void injectedMethod() {
        // do actual stuff
        System.out.println("Injected method called.");
    }
}

public class Main_16 {
    public static void main(String[] args) throws Exception {
        MyClass altered = (MyClass) doMagic(MyClass.class, Overrider.class, Injector.class);
        altered.myMethod();  // should print "Injected method called."
    }

    private static Object doMagic(Class<?> superClazz, Class<?> overridingClazz, Class<?> injectingClazz) throws Exception {
        // Create a byte[] that contains the byte code of the generated class.
        byte[] newClassByteCode = buildNewClassWithOverrides(superClazz, overridingClazz, injectingClazz);
        return loadClassAndCreateInstance(newClassByteCode, superClazz);
    }

    private static byte[] buildNewClassWithOverrides(Class<?> superClass, Class<?> overridingClass, Class<?> injectingClass) throws IOException {
        // Create a JavaClass object using the Superclass
        String superClassName = superClass.getName();
        String superClassPath = superClassName.replace('.', '/') + ".class";
        InputStream superClassStream = superClass.getResourceAsStream("/" + superClassPath);

        ClassParser parser = new ClassParser(superClassStream, superClassName);
        JavaClass superClassJavaClass = parser.parse();

        ConstantPoolGen constPoolGen = new ConstantPoolGen(superClassJavaClass.getConstantPool());

        // Create a new ClassGen to generate a new class
        String newClassName = overridingClass.getName() + "Altered";
        ClassGen classGen = new ClassGen(newClassName, superClassJavaClass.getClassName(), superClassJavaClass.getSourceFileName(),
                Const.ACC_PUBLIC | Const.ACC_SUPER, null);

        classGen.setConstantPool(constPoolGen);

        // Add a default constructor
        MethodGen constructor = new MethodGen(Const.ACC_PUBLIC, Type.VOID, new Type[]{}, new String[]{}, "<init>", newClassName, new InstructionList(), constPoolGen);
        InstructionList il = constructor.getInstructionList();
        il.append(InstructionFactory.createLoad(Type.OBJECT, 0));
        il.append(new INVOKESPECIAL(constPoolGen.addMethodref(superClassJavaClass.getClassName(), "<init>", "()V")));
        il.append(InstructionFactory.createReturn(Type.VOID));
        constructor.setMaxStack();
        constructor.setMaxLocals();
        classGen.addMethod(constructor.getMethod());
        il.dispose();

        Method[] methodsToOverride = overridingClass.getDeclaredMethods();

        for (Method method : methodsToOverride) {
            if (method.isDefault()) continue; // Skip default interface implementation

            MethodGen methodGen = new MethodGen(Const.ACC_PUBLIC,
                                                Type.getType(method.getReturnType()),
                                                Type.getTypes(method.getParameterTypes()),
                                                null,
                                                method.getName(),
                                                newClassName,
                                                new InstructionList(),
                                                constPoolGen);

            InstructionList methodIl = methodGen.getInstructionList();
            InstructionFactory factory = new InstructionFactory(classGen, constPoolGen);

            // Call the injectingClass.injectedMethod()
            methodIl.append(factory.createInvoke(injectingClass.getName(), "injectedMethod", Type.VOID, Type.NO_ARGS, Const.INVOKESTATIC));

            methodIl.append(InstructionFactory.createReturn(Type.getType(method.getReturnType())));
            methodGen.setMaxStack();
            methodGen.setMaxLocals();
            classGen.addMethod(methodGen.getMethod());
            methodIl.dispose();
        }

        JavaClass newClass = classGen.getJavaClass();

        return newClass.getBytes();
    }

    private static Object loadClassAndCreateInstance(byte[] newClassByteCode, Class<?> superClass) throws Exception {
        // Create a custom class loader
        ClassLoader parentClassLoader = superClass.getClassLoader();
        MyClassLoader classLoader = new MyClassLoader(parentClassLoader);

        // Define the new class
        Class<?> loadedClass = classLoader.defineClassFromBytes(newClassByteCode);

        // Return an instance of the newly created class
        return loadedClass.getDeclaredConstructor().newInstance();
    }

    static class MyClassLoader extends ClassLoader {
        public MyClassLoader(ClassLoader parent) {
            super(parent);
        }

        public Class<?> defineClassFromBytes(byte[] classBytes) {
            return defineClass(null, classBytes, 0, classBytes.length);
        }
    }
}