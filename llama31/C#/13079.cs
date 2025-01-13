using System.Xml.Linq;\n\nXDocument doc = XDocument.Load("example.xml");\nvar elements = doc.Descendants("elementName");\n\nforeach (var element in elements)\n{\n    Console.WriteLine(element.Value);\n}