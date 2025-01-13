/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;

public class Tag {
    private Hashtable<String, String> attributes = new Hashtable();

    public void setAttribute(String string, String string2) {
        this.attributes.put(string, string2);
    }

    public String getAttribute(String string) {
        return this.attributes.get(string);
    }

    public static void main(String[] stringArray) {
    }
}
