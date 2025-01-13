/*
 * Decompiled with CFR 0.152.
 */
public class XmlCharacterHandler {
    public static void main(String[] stringArray) {
        XmlCharacterHandler xmlCharacterHandler = new XmlCharacterHandler();
        String string = "your_string_here";
        xmlCharacterHandler.process(string);
    }

    public void process(String string) {
        XmlHandler xmlHandler = new XmlHandler();
        xmlHandler.startCDATA();
        xmlHandler.characters(string.toCharArray(), 0, string.length());
        xmlHandler.endCDATA();
    }
}
