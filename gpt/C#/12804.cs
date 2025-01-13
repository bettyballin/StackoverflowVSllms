using System;\nusing System.Xml;\n\npublic static void TestXPath()\n{\n    string xmlText = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";\n    xmlText += "<Properties xmlns=\"http://schemas.openxmlformats.org/officeDocument/2006/extended-properties\" xmlns:vt=\"http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes\">";\n    xmlText += "<Template>Normal</Template>  <TotalTime>1</TotalTime>  <Pages>1</Pages>  <Words>6</Words>";\n    xmlText += "</Properties>";\n\n    XmlDocument xmlDoc = new XmlDocument();\n    xmlDoc.Load(new System.IO.StringReader(xmlText));\n\n    XmlNamespaceManager nsmgr = new XmlNamespaceManager(xmlDoc.NameTable);\n    nsmgr.AddNamespace("ns", "http://schemas.openxmlformats.org/officeDocument/2006/extended-properties");\n\n    foreach (XmlNode node in xmlDoc.SelectNodes("//ns:Template", nsmgr))\n    {\n        Console.WriteLine("{0}: {1}", node.Name, node.InnerText);\n    }\n}