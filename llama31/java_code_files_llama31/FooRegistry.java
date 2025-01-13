/*
 * Decompiled with CFR 0.152.
 */
public class FooRegistry {
    private static void addController(IFooController iFooController) {
    }

    public static void main(String[] stringArray) {
    }

    static {
        FooRegistry.addController(new FooControllerImpl());
    }
}
