import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.ConstantUtf8;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.INVOKEDYNAMIC;
import org.apache.bcel.generic.INVOKEINTERFACE;
import org.apache.bcel.generic.INVOKESPECIAL;
import org.apache.bcel.generic.INVOKESTATIC;
import org.apache.bcel.generic.INVOKEVIRTUAL;
import org.apache.bcel.generic.MethodInvocation;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.Instruction;
import java.util.Iterator;

public class MethodInvocationCounter {
    public int countR(String classPath, String className) throws Exception {
        ClassParser parser = new ClassParser(classPath);
        JavaClass javaClass = parser.parse();
        Method[] methods = javaClass.getMethods();
        InstructionFactory factory = new InstructionFactory(javaClass);
        ConstantUtf8 consName;

        int countInvoke = 0; // keep track of invoke instructions.

        // Iterate through methods.
        for (Method method : methods) {
            Code codeAttr = method.getCode();
            if (codeAttr != null) {
                InstructionList il = new InstructionList(codeAttr.getCode());
                InstructionHandle[] handles = il.getInstructionHandles();
                // Now check each instruction in this list. If it's invoking a method, increment count.
                for (InstructionHandle ih : handles) {
                    Instruction inst = ih.getInstruction();
                    if ((inst instanceof INVOKEDYNAMIC || inst instanceof INVOKEINTERFACE ||
                            inst instanceof INVOKESPECIAL || inst instanceof INVOKESTATIC ||
                            inst instanceof INVOKEVIRTUAL) && !(inst instanceof MethodInvocation)) {
                        // it's a method invoking instruction. Count++.
                        ++countInvoke;
                    }
                }
            }
        }
        return countInvoke;
    }

    public static void main(String[] args) {
    }
}