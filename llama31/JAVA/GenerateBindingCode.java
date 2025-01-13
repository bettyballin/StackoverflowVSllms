import org.apache.xmlbeans.XmlBeans;

public class GenerateBindingCode {
  public static void main(String[] args) {
    String dtdFile = "mydtd.dtd";
    String javaPackage = "mypackage";
    XmlBeans.compileXmlBeans(dtdFile, javaPackage, null);
  }
}