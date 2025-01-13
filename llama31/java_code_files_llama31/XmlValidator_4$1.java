/*
 * Decompiled with CFR 0.152.
 */
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

static class XmlValidator_4.1
implements ErrorHandler {
    XmlValidator_4.1() {
    }

    @Override
    public void warning(SAXParseException sAXParseException) throws SAXException {
    }

    @Override
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
    }

    @Override
    public void error(SAXParseException sAXParseException) throws SAXException {
        System.out.println("Validation error at line " + sAXParseException.getLineNumber() + ", column " + sAXParseException.getColumnNumber() + ": " + sAXParseException.getMessage());
    }
}
