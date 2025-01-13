/*
 * Decompiled with CFR 0.152.
 */
class RequestBuilder {
    public static final String POST = "POST";
    private String method;
    private String path;

    public RequestBuilder(String string, String string2) {
        this.method = string;
        this.path = string2;
    }

    public void setHeader(String string, String string2) {
        System.out.println("Setting header: " + string + " = " + string2);
    }
}
