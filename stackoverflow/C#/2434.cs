public class MyXmlCustomConfigSection : MyCustomConfigSection\n{\n    public MyXmlCustomConfigSection (string configXml)\n    {\n        XmlTextReader reader = new XmlTextReader(new StringReader(configXml));\n        DeserializeSection(reader);\n    }\n}