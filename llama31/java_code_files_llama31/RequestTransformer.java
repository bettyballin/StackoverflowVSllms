/*
 * Decompiled with CFR 0.152.
 */
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

public class RequestTransformer {
    public static void main(String[] stringArray) throws Exception {
        Object var1_1 = null;
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setParameter("color", var1_1.getParameter("color"));
        transformer.setParameter("number", var1_1.getParameter("number"));
    }
}
