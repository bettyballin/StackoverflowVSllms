/*
 * Decompiled with CFR 0.152.
 */
public class ObjC {
    private ObjB objB;

    public ObjC(ObjB objB) {
        this.objB = objB;
    }

    public void doSomething() {
        this.objB.runMethodXinA();
    }

    public static void main(String[] stringArray) {
        ObjB objB = new ObjB();
        ObjC objC = new ObjC(objB);
        objC.doSomething();
    }
}
