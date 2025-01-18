import java.lang.instrument.Instrumentation;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class InstancesCountAgent {
    private static Instrumentation inst;

    public static void premain(String agentArgs, final Instrumentation paramInstr) throws Exception {
        System.out.println("Pre-main was invoked.");
        long maxAlloc = Long.MAX_VALUE; // Disable allocation limit for simplicity
        inst = paramInstr;
        inst.addTransformer(new ClassFileTransformer() {
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain domain, byte[] bytes) throws IllegalClassFormatException {
                // Transform loaded classes only once:
                if (className != null && !className.equals("java/lang/String") && !className.contains("InstancesCountAgent")) {
                    // Print instance count of each class during JVM shutdown process:
                    String finalName = className;
                    Runtime.getRuntime().addShutdownHook(new Thread() {
                        public void run() {
                            Class<?> klass = null;
                            try {
                                klass = Class.forName(finalName);
                                System.out.printf("Class %s had %d instances%n", klass.getSimpleName(), inst.getObjectSize(klass));
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });

                    System.out.printf("Agent transformed %s%n", className);
                    return bytes;
                }
                // Return untransformed byte code:
                if (className != null) {
                    System.out.printf("Class %s was not processed!%n", className);
                }
                return null;
            }
        });
    }
}