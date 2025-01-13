// Read in Xml-file \n        XmlDocument doc = new XmlDocument();\n        doc.Load("C:/Web.config");\n\n        //SaveControl tag..........................................................\n        XmlNode n = doc.SelectSingleNode("/configuration/SharePoint/SafeControls");\n\n        XmlElement elemWeb = doc.CreateElement("SafeControl");\n        elemWeb.SetAttribute("Assembly", "SamrasWebOption4");\n        elemWeb.SetAttribute("Namespace", "SamrasWebOption4");\n        elemWeb.SetAttribute("TypeName", "*");\n        elemWeb.SetAttribute("Safe", "True");\n\n        XmlElement elemSmartPart = doc.CreateElement("SafeControl");\n        elemSmartPart.SetAttribute("Assembly", "Machine_Totals");\n        elemSmartPart.SetAttribute("Namespace", "Machine_Totals");\n        elemSmartPart.SetAttribute("TypeName", "*");\n        elemSmartPart.SetAttribute("Safe", "True");\n\n        //Appending the Nodes......................................................\n        n.AppendChild(elemWeb);\n        n.AppendChild(elemSmartPart);\n\n        //Saving the document......................................................\n        doc.Save("C:/Web.config");