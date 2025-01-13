/*
 * Decompiled with CFR 0.152.
 */
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;

public class XSLTransformerUtil {
    private static TransformerFactory factory;

    public static void main(String[] stringArray) {
    }

    static {
        try {
            factory = TransformerFactory.newInstance("org.apache.xalan.xsltc.trax.TransformerFactoryImpl", null);
        }
        catch (TransformerFactoryConfigurationError transformerFactoryConfigurationError) {
            transformerFactoryConfigurationError.printStackTrace();
        }
    }
}
