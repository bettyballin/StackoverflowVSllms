// Example of using XmlDocument and XPath in C#\n  using System.Xml;\n\n  public class XmlDocumentXPathExample {\n      public static void Main() {\n          XmlDocument doc = new XmlDocument();\n          doc.Load("yourfile.xml");\n          XmlNodeList nl = doc.SelectNodes("//YourXPathQuery");\n      }\n  }