/*
 * Decompiled with CFR 0.152.
 */
public class FooHome {
    public void update() {
        boolean bl = false;
        if (bl) {
            this.redirectOnValidationError();
        }
    }

    private void redirectOnValidationError() {
        System.out.println("Validation failed. Redirecting...");
    }

    public static void main(String[] stringArray) {
        FooHome fooHome = new FooHome();
        fooHome.update();
    }
}
