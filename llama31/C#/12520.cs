using System.Xml.Linq;\n\n// Assuming e.Result is the XML string from the WebClient call\nstring xmlString = e.Result;\n\n// Unescape the XML string\nxmlString = xmlString.Replace("\\n", "\n").Replace("\\t", "\t");\n\n// Parse the XML string\nXDocument xml = XDocument.Parse(xmlString);\n\n// Now you should be able to access the XML elements as expected\nXElement nameNode = xml.Element("name");