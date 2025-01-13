/*
 * Decompiled with CFR 0.152.
 */
public class JsonViewController {
    public String myJsonView() {
        return "{\"key\":\"value\"}";
    }

    public static void main(String[] stringArray) {
        JsonViewController jsonViewController = new JsonViewController();
        System.out.println(jsonViewController.myJsonView());
    }
}
