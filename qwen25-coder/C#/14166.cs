using System;\nusing System.Xml;\n\nclass Program {\n    static void Main() {\n        XmlDocument doc = new XmlDocument();\n        doc.LoadXml("<root xmlns='uri'><foo /></root>");\n\n        XmlNamespaceManager nsmgr = new XmlNamespaceManager(doc.NameTable);\n        nsmgr.AddNamespace("ns", "uri");\n\n        XmlNode node = doc.SelectSingleNode("//ns:foo", nsmgr);\n\n        if (node != null) {\n            Console.WriteLine(node.OuterXml); // Outputs the <foo> element\n        }\n    }\n}