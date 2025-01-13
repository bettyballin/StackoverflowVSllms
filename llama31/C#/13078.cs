using System.Xml;\n\nXmlDocument doc = new XmlDocument();\ndoc.Load("example.xml");\nXmlNodeList elements = doc.SelectNodes("//elementName");\n\nforeach (XmlNode element in elements)\n{\n    Console.WriteLine(element.InnerText);\n}