using System.Xml.Linq;\n   \n   // Load XML from file\n   XDocument xDoc = XDocument.Load("path_to_your_file.xml");\n\n   // Parse XML\n   foreach (XElement element in xDoc.Descendants("YourElementName")) {\n       // Do something with element\n   }\n\n   // Save XML to file\n   xDoc.Save("path_to_your_file.xml");