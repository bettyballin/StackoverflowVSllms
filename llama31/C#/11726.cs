string xml = Encoding.UTF8.GetString(ms.ToArray());\nXmlDocument xmlDoc = new XmlDocument();\nxmlDoc.LoadXml(xml);