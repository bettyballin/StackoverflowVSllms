/*
 * Decompiled with CFR 0.152.
 */
public class MethodOverloadExample {
    public static void doSomething(Base base) {
        System.out.println("BASE CALLED");
    }

    public static void doSomething(Sub sub) {
        System.out.println("SUB CALLED");
    }

    public static void doSomething(SubSub subSub) {
        System.out.println("SUBSUB CALLED");
    }

    public static void main(String[] stringArray) {
        SubSub subSub = new SubSub();
        MethodOverloadExample.doSomething(subSub);
    }
}
