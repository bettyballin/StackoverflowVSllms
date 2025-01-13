/*
 * Decompiled with CFR 0.152.
 */
public class TestClient {
    public static void main(String[] stringArray) {
        YourServiceStub yourServiceStub = new YourServiceStub();
        for (int i = 0; i < 100; ++i) {
            try {
                yourServiceStub.yourMethod();
                Thread.sleep(100L);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
