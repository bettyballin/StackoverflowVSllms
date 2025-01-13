/*
 * Decompiled with CFR 0.152.
 */
public class MyThirdClass {
    private final String componentB;

    public MyThirdClass(String string) {
        this.componentB = string;
    }

    public static void main(String[] stringArray) {
        MyThirdClass myThirdClass = new MyThirdClass("Example Component B");
        System.out.println("Created MyThirdClass instance with componentB: " + myThirdClass.componentB);
    }
}
