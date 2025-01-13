using System.Xml;\nusing System.Xml.Xsl;\n\npublic class XmlTransformer {\n    public static void Main(string[] args) {\n        // Load internal XML\n        XmlDocument internalXml = new XmlDocument();\n        internalXml.Load("internal.xml");\n\n        // Load XSLT transformation\n        XslCompiledTransform xslt = new XslCompiledTransform();\n        xslt.Load("transform.xsl");\n\n        // Transform internal XML to external XML\n        using (XmlWriter externalXml = XmlWriter.Create("external.xml")) {\n            xslt.Transform(internalXml, externalXml);\n        }\n    }\n}