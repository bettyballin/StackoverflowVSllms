using System;\nusing System.Xml;\n\nclass Program\n{\n    static void Main()\n    {\n        XmlDocument doc = new XmlDocument();\n        \n        // Load or create your XML document here\n        // For example, creating a new XML document:\n        XmlElement root = doc.CreateElement("Root");\n        doc.AppendChild(root);\n\n        // Create the Property element with attributes\n        XmlElement propertyElement = doc.CreateElement("Property");\n        propertyElement.SetAttribute("name", "someName");\n        propertyElement.SetAttribute("type", "String");\n\n        // Create the CDATA section with the desired value\n        XmlCDataSection cdata = doc.CreateCDataSection("someValue");\n\n        // Append the CDATA section to the Property element\n        propertyElement.AppendChild(cdata);\n\n        // Append the Property element to the root or desired node\n        root.AppendChild(propertyElement);\n\n        // Save or display the XML document\n        Console.WriteLine(doc.OuterXml);\n    }\n}