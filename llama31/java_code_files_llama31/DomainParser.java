/*
 * Decompiled with CFR 0.152.
 */
import java.net.URI;
import java.net.URISyntaxException;

public class DomainParser {
    public static String getDomain(String string) throws URISyntaxException {
        URI uRI = new URI(string);
        return uRI.getHost();
    }

    public static void main(String[] stringArray) throws URISyntaxException {
        System.out.println(DomainParser.getDomain("http://google.com/dhasjkdas/sadsdds/sdda/sdads.html"));
        System.out.println(DomainParser.getDomain("http://www.google.com/dhasjkdas/sadsdds/sdda/sdads.html"));
        System.out.println(DomainParser.getDomain("http://google.co.uk/dhasjkdas/sadsdds/sdda/sdads.html"));
    }
}
