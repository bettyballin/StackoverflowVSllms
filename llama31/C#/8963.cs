using System;\nusing System.Xml;\n\npublic class XmlLogExtractor\n{\n    public static string ExtractXmlMessage(string logFile, string nodeName, string nodeValue)\n    {\n        XmlDocument xmlDoc = new XmlDocument();\n        xmlDoc.Load(logFile);\n\n        string xpath = $"//*[local-name()='{nodeName}' and text()='{nodeValue}']";\n\n        XmlNode node = xmlDoc.SelectSingleNode(xpath);\n\n        if (node != null)\n        {\n            return node.OuterXml;\n        }\n\n        return null;\n    }\n}