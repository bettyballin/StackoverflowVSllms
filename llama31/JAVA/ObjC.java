// Define the missing class ObjB
class ObjB {
    public void runMethodXinA() {
        System.out.println("Running methodXinA from ObjB");
    }
}

public class ObjC {
    private ObjB objB;

    public ObjC(ObjB objB) {
        this.objB = objB;
    }

    public void doSomething() {
        objB.runMethodXinA();
    }

    public static void main(String[] args) {
        // Create an instance of ObjB
        ObjB objB = new ObjB();
        
        // Create an instance of ObjC with objB
        ObjC objC = new ObjC(objB);
        
        // Call doSomething on objC
        objC.doSomething();
    }
}