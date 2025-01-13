import java.lang.String;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.*;

public class RFCMetricCalculator {

    public static int calculateRFC(String className) throws Exception {
        ClassParser parser = new ClassParser(className);
        JavaClass javaClass = parser.parse();

        int methodCount = 0;
        int referencedMethods = 0;

        // Iterate over all methods in the class
        for (Method method : javaClass.getMethods()) {
            methodCount++;

            // Get the method's bytecode
            Code code = method.getCode();

            // Iterate over all instructions in the method
            for (Instruction instruction : code.getInstructions()) {
                // Check if the instruction is a method invocation
                if (instruction instanceof InvokeInstruction) {
                    referencedMethods++;
                }
            }
        }

        return methodCount + referencedMethods;
    }

    public static void main(String[] args) throws Exception {
        String className = "J";
        int rfc = calculateRFC(className);
        System.out.println("RFC for class " + className + ": " + rfc);
    }
}