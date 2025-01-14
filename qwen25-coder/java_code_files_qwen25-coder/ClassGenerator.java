import org.objectweb.asm.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class SimpleClassGenerator extends ClassVisitor {
    public SimpleClassGenerator(ClassWriter cw) {
        super(Opcodes.ASM8, cw);
    }

    @Override
    public MethodVisitor visitMethod(
            int access, String name, String descriptor, String signature, String[] exceptions) {
        if (!name.equals("<init>")) return null;
        MethodVisitor mv = cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                "<init>",
                "()V",
                null,
                null);
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                "java/lang/Object",
                "<init>",
                "()V", false
        );
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
        return mv;
    }
}

public class ClassGenerator {
    public static void main(String[] args) throws Exception {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(
                Opcodes.V1_8,
                Opcodes.ACC_PUBLIC,
                "SimpleClass",
                null, "java/lang/Object", null);
        SimpleClassGenerator scg = new SimpleClassGenerator(cw);
        scg.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        cw.visitEnd();
        byte[] bytecode = cw.toByteArray();

        Files.write(
                Paths.get(System.getProperty("user.dir") + "/SimpleClass.class"),
                bytecode
        );
    }
}