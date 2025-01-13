/*
 * Decompiled with CFR 0.152.
 */
class SecurityInterceptor {
    SecurityInterceptor() {
    }

    public void onPrepareStatement(String string, Object object) {
        if (object instanceof MyEntity_23) {
            System.out.println("Adding filter condition");
        }
    }

    public static void main(String[] stringArray) {
        SecurityInterceptor securityInterceptor = new SecurityInterceptor();
        securityInterceptor.onPrepareStatement("", new MyEntity_23());
    }
}
