import org.apache.bcel.Repository;
import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;

public class RFCAnalysis {
    public static void main(String[] args) throws Exception {
        String className = "J"; // Name of the class to analyze
        JavaClass clazz = Repository.lookupClass(className);
        Method[] methods = clazz.getMethods();

        int M = methods.length;
        int R = 0;

        ConstantPoolGen cpg = new ConstantPoolGen(clazz.getConstantPool());

        for (Method method : methods) {
            MethodGen mg = new MethodGen(method, clazz.getClassName(), cpg);
            InstructionList il = mg.getInstructionList();
            InstructionHandle[] handles = il.getInstructionHandles();

            for (InstructionHandle ih : handles) {
                Instruction ins = ih.getInstruction();
                if (ins instanceof InvokeInstruction) {
                    R++;
                }
            }
        }

        System.out.println("M: " + M);
        System.out.println("R: " + R);
        System.out.println("RFC: " + (M + R));
    }
}