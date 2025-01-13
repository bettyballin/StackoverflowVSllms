import java.lang.String;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MethodOverrider {
    public static Class<?> overrideMethod(Class<?> clazz, String methodName, String injectorMethodName) throws Exception {
        ClassReader cr = new ClassReader(clazz.getName());
        ClassWriter cw = new ClassWriter(cr, 0);
        cr.accept(new MethodOverridingVisitor(cw, methodName, injectorMethodName), 0);
        byte[] newClassBytes = cw.toByteArray();
        return defineClass(clazz.getName(), newClassBytes);
    }

    private static class MethodOverridingVisitor extends ClassVisitor {
        private final String methodName;
        private final String injectorMethodName;

        public MethodOverridingVisitor(ClassVisitor cv, String methodName, String injectorMethodName) {
            super(Opcodes.ASM9, cv);
            this.methodName = methodName;
            this.injectorMethodName = injectorMethodName;
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            if (name.equals(methodName)) {
                return new InjectorMethodVisitor(cv.visitMethod(access, name, descriptor, signature, exceptions), injectorMethodName);
            }
            return cv.visitMethod(access, name, descriptor, signature, exceptions);
        }
    }

    private static class InjectorMethodVisitor extends MethodVisitor {
        private final String injectorMethodName;

        public InjectorMethodVisitor(MethodVisitor mv, String injectorMethodName) {
            super(Opcodes.ASM9, mv);
            this.injectorMethodName = injectorMethodName;
        }

        @Override
        public void visitCode() {
            super.visitMethodInsn(Opcodes.INVOKESTATIC, "Injector", injectorMethodName, "()V", false);
        }
    }

    private static Class<?> defineClass(String className, byte[] classBytes) throws Exception {
        ClassLoader cl = MethodOverrider.class.getClassLoader();
        return cl.defineClass(className, classBytes, 0, classBytes.length);
    }

    public static void main(String[] args) throws Exception {
        Class<?> alteredClass = overrideMethod(Overrider.class, "myMethod", "myMethod");
        Object alteredInstance = alteredClass.getConstructor().newInstance();
        alteredClass.getMethod("myMethod").invoke(alteredInstance);
    }
}

class Overrider {
    public void myMethod() {
        System.out.println("Original method called");
    }

    public Overrider() {}
}

class Injector {
    public static void myMethod() {
        System.out.println("Injected method called");
    }
}