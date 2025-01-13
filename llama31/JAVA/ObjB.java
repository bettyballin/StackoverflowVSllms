import java.lang.String;

interface MethodXRunner {
    void runMethodX();
}

public class ObjB {
    private MethodXRunner methodXRunner;

    public ObjB(MethodXRunner methodXRunner) {
        this.methodXRunner = methodXRunner;
    }

    public void runMethodXinA() {
        methodXRunner.runMethodX();
    }

    public static void main(String[] args) {
        // Example usage
        MethodXRunner runner = new MethodXRunner() {
            @Override
            public void runMethodX() {
                System.out.println("Running Method X");
            }
        };
        ObjB objB = new ObjB(runner);
        objB.runMethodXinA();
    }
}