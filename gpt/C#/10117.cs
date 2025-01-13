using System;\nusing System.Xml;\n\nclass Program\n{\n    static void Main()\n    {\n        XmlDocument doc = new XmlDocument();\n        doc.InnerXml = @"<Element1 attr1=""value1"" xmlns=""http://mynamespace.com/"" attr2=""value2""/>";\n\n        // Create a new element without the namespace\n        XmlElement newElement = doc.CreateElement(doc.DocumentElement.LocalName);\n\n        // Copy attributes except xmlns\n        foreach (XmlAttribute attr in doc.DocumentElement.Attributes)\n        {\n            if (attr.Name != "xmlns")\n            {\n                newElement.SetAttribute(attr.Name, attr.Value);\n            }\n        }\n\n        // Copy child nodes\n        while (doc.DocumentElement.HasChildNodes)\n        {\n            newElement.AppendChild(doc.DocumentElement.FirstChild);\n        }\n\n        // Replace the old element with the new one\n        doc.ReplaceChild(newElement, doc.DocumentElement);\n\n        Console.WriteLine(doc.OuterXml);\n    }\n}