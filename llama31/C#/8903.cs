using System.Data;\nusing System.Xml;\n\n// ...\n\nds.WriteXml(strXmlTestCasePath, XmlWriteMode.IgnoreSchema);\n\n// Load the generated XML into an XmlDocument\nXmlDocument xmlDoc = new XmlDocument();\nxmlDoc.Load(strXmlTestCasePath);\n\n// Create a new XmlNode with the extra information\nXmlNode extraInfoNode = xmlDoc.CreateElement("extraInfo");\nextraInfoNode.InnerText = "This is some extra information";\n\n// Add the extra information node to the root of the XML\nxmlDoc.DocumentElement.AppendChild(extraInfoNode);\n\n// Save the modified XML back to the file\nxmlDoc.Save(strXmlTestCasePath);