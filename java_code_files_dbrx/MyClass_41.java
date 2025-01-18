import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;

public class MyClass {

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.initComputeThread();
    }

    private void initComputeThread() {
        final Node root; // compute method
        final JEP j = new JEP();
        // Add variables and operations to the 'node' tree then parse it to extract computation 'root'
        root = j.parse("var1 + var2"); // replace with your function

        Thread cThread = new Thread() {
            public void run() {
                float result;
                float varValue1 = 0f;
                float varValue2 = 0f;
                while (true) {
                    // Get variable values here from UI or external source then...
                    j.addVariable("var1", varValue1);
                    j.addVariable("var2", varValue2);
                    // Similar to other variables used in the computation 'root' tree structure
                    // Perform simulation computations here
                    result = (float) j.evaluate(root);
                    // Get the value of the computed operation and use it accordingly...
                    System.out.println("Result: " + result);

                    // Update variable values for demonstration purposes
                    varValue1 += 1;
                    varValue2 += 2;

                    // Pause for a while to observe the output
                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Break the loop after a condition is met for demonstration purposes
                    if (varValue1 > 10) {
                        break;
                    }
                }
            }
        };
        cThread.start();
    }
}