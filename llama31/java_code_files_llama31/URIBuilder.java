/*
 * Decompiled with CFR 0.152.
 */
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URIBuilder {
    private StringBuilder queryString = new StringBuilder();

    public URIBuilder addParameter(String string, String string2) {
        if (this.queryString.length() > 0) {
            this.queryString.append("&");
        }
        try {
            this.queryString.append(URLEncoder.encode(string, StandardCharsets.UTF_8.toString())).append("=").append(URLEncoder.encode(string2, StandardCharsets.UTF_8.toString()));
        }
        catch (Exception exception) {
            // empty catch block
        }
        return this;
    }

    public URI build() {
        try {
            return new URI("?" + this.queryString.toString());
        }
        catch (URISyntaxException uRISyntaxException) {
            return null;
        }
    }

    public static void main(String[] stringArray) {
        URIBuilder uRIBuilder = new URIBuilder();
        String string = uRIBuilder.addParameter("username", "john").addParameter("password", "123").build().toString();
        System.out.println(string);
    }
}
