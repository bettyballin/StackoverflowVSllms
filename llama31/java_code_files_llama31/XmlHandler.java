/*
 * Decompiled with CFR 0.152.
 */
class XmlHandler {
    XmlHandler() {
    }

    public void startCDATA() {
        System.out.println("<![CDATA[");
    }

    public void characters(char[] cArray, int n, int n2) {
        System.out.println(String.valueOf(cArray, n, n2));
    }

    public void endCDATA() {
        System.out.println("]]>");
    }
}
