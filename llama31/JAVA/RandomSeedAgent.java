import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Random;

public class RandomSeedAgent implements ClassFileTransformer {

    private static final long DEFAULT_SEED = 123456789L;

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className.equals("java/util/Random")) {
            // Set the seed to the default value
            Random random = new Random(DEFAULT_SEED);
            // Return the modified class file
            return modifyClassFile(classfileBuffer, random);
        }
        return classfileBuffer;
    }

    private byte[] modifyClassFile(byte[] classfileBuffer, Random random) {
        // Use a bytecode manipulation library such as ASM to modify the class file
        // This example uses ASM to set the seed in the Random constructor
        ClassReader reader = new ClassReader(classfileBuffer);
        ClassWriter writer = new ClassWriter(reader, 0);
        ClassVisitor visitor = new ClassVisitor(Opcodes.ASM9, writer) {
            @Override
            public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                if (name.equals("<init>")) {
                    // Set the seed in the constructor
                    visitor.visitVarInsn(Opcodes.LLOAD, 1);
                    visitor.visitInsn(Opcodes.LCONST_0);
                    visitor.visitInsn(Opcodes.LXOR);
                    visitor.visitInsn(Opcodes.L2I);
                    visitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Random", "setSeed", "(J)V", false);
                }
                super.visitMethodInsn(opcode, owner, name, desc, itf);
            }
        };
        reader.accept(visitor, 0);
        return writer.toByteArray();
    }

    public static void main(String[] args) {
    }
}