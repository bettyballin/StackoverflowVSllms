/*
 * Decompiled with CFR 0.152.
 */
public class NamespaceContextImpl {
    public String getNamespaceURI(String string) {
        if (string == null || string.equals("")) {
            return "http://www.w3.org/1999/xhtml";
        }
        return null;
    }

    public static void main(String[] stringArray) {
        NamespaceContextImpl namespaceContextImpl = new NamespaceContextImpl();
        System.out.println(namespaceContextImpl.getNamespaceURI(null));
        System.out.println(namespaceContextImpl.getNamespaceURI(""));
        System.out.println(namespaceContextImpl.getNamespaceURI("somePrefix"));
    }
}
