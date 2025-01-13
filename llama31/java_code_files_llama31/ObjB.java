/*
 * Decompiled with CFR 0.152.
 */
public class ObjB {
    private MethodXRunner methodXRunner;

    public ObjB(MethodXRunner methodXRunner) {
        this.methodXRunner = methodXRunner;
    }

    public void runMethodXinA() {
        this.methodXRunner.runMethodX();
    }

    public static void main(String[] stringArray) {
        MethodXRunner methodXRunner = new MethodXRunner(){

            @Override
            public void runMethodX() {
                System.out.println("Running Method X");
            }
        };
        ObjB objB = new ObjB(methodXRunner);
        objB.runMethodXinA();
    }
}
