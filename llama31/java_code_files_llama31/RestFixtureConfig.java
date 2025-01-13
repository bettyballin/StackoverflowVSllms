/*
 * Decompiled with CFR 0.152.
 */
public class RestFixtureConfig {
    private String url;
    private int port;
    private boolean encode;

    public RestFixtureConfig(String string, int n, boolean bl) {
        this.url = string;
        this.port = n;
        this.encode = bl;
    }

    public String getUrl() {
        return this.url;
    }

    public int getPort() {
        return this.port;
    }

    public boolean isEncode() {
        return this.encode;
    }

    public static void main(String[] stringArray) {
        RestFixtureConfig restFixtureConfig = new RestFixtureConfig("http://your-tomcat-url.com", 8080, true);
        System.out.println("URL: " + restFixtureConfig.getUrl());
        System.out.println("Port: " + restFixtureConfig.getPort());
        System.out.println("Encode: " + restFixtureConfig.isEncode());
    }
}
