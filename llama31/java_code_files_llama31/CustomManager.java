/*
 * Decompiled with CFR 0.152.
 */
public class CustomManager
extends StandardManager {
    @Override
    public int getSessionIdLength() {
        return 20;
    }

    public static void main(String[] stringArray) {
        CustomManager customManager = new CustomManager();
        System.out.println("Custom Session ID Length: " + customManager.getSessionIdLength());
    }
}
