/*
 * Decompiled with CFR 0.152.
 */
public class MyWizard
extends Wizard {
    @Override
    public boolean canFlipToPreviousPage() {
        return false;
    }

    public static void main(String[] stringArray) {
        MyWizard myWizard = new MyWizard();
        System.out.println("Can flip to previous page: " + myWizard.canFlipToPreviousPage());
    }
}
