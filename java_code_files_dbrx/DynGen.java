import java.io.*;
import org.objectweb.asm.*;

public class DynGen implements Opcodes {
    public static void main(String[] args) throws Exception {
        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;

        // Generate MyClass{int i}
        cw.visit(V1_8, ACC_PUBLIC + ACC_SUPER, "MyClass", null, "java/lang/Object", new String[] {});

        fv = cw.visitField(ACC_PRIVATE, "i", "I", null, null);
        fv.visitEnd(); // end field visit and its contents

        mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(8, l0);
        mv.visitVarInsn(ALOAD, 0); // Load "this" onto the stack
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        mv.visitInsn(RETURN);
        Label l1 = new Label();
        mv.visitLabel(l1);
        mv.visitLocalVariable("this", "LMyClass;", null, l0, l1, 0); // name, type, signatures and variable-indices
        mv.visitMaxs(-1, -1); // max stack and max locals
        mv.visitEnd(); // end of method body visit/code

        cw.visitEnd();
    }
}