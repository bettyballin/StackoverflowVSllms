using System;\nusing System.IO;\nusing System.Reflection;\nusing System.Xml;\nusing System.Xml.Resolvers;\n\npublic class DtdCachingExample\n{\n    public static XmlDocument LoadXmlDocumentWithCachedDtd(string xmlContent)\n    {\n        // Create an XmlPreloadedResolver\n        XmlPreloadedResolver resolver = new XmlPreloadedResolver();\n\n        // Load the DTD from the embedded resource\n        Assembly assembly = Assembly.GetExecutingAssembly();\n        using (Stream dtdStream = assembly.GetManifestResourceStream("YourNamespace.YourDtdFile.dtd"))\n        {\n            if (dtdStream == null)\n            {\n                throw new FileNotFoundException("DTD resource not found.");\n            }\n\n            // Add DTD to the resolver\n            resolver.Add(new Uri("-//W3C//DTD XHTML 1.0 Strict//EN", UriKind.RelativeOrAbsolute), dtdStream);\n        }\n\n        // Set up XmlReaderSettings to use the preloaded resolver\n        XmlReaderSettings settings = new XmlReaderSettings\n        {\n            DtdProcessing = DtdProcessing.Parse,\n            XmlResolver = resolver\n        };\n\n        // Load the XML document using the settings\n        using (StringReader stringReader = new StringReader(xmlContent))\n        using (XmlReader xmlReader = XmlReader.Create(stringReader, settings))\n        {\n            XmlDocument xmlDocument = new XmlDocument();\n            xmlDocument.Load(xmlReader);\n            return xmlDocument;\n        }\n    }\n\n    public static void Main()\n    {\n        string xmlContent = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">"\n                            + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"\n                            + "<head><title>Example</title></head>"\n                            + "<body>&nbsp;Example</body>"\n                            + "</html>";\n\n        XmlDocument document = LoadXmlDocumentWithCachedDtd(xmlContent);\n        Console.WriteLine(document.OuterXml);\n    }\n}