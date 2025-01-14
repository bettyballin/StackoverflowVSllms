import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class in implements Opcodes {
    // Example of using ASM library to generate a simple Hello World class in JVM bytecode
    public void generateHelloWorldClass() throws IOException {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(V1_8, ACC_PUBLIC, "HelloWorld", null, "java/lang/Object", null);

        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv.visitInsn(RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();

        mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("Hello World");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mv.visitInsn(RETURN);
        mv.visitMaxs(2, 1);
        mv.visitEnd();

        cw.visitEnd();
        Files.write(new File("HelloWorld.class").toPath(), cw.toByteArray());
    }

    public static void main(String[] args) {
    }
}