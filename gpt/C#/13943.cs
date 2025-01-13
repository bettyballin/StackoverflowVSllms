using System.Xml;\nusing System.Xml.XPath;\n\npublic XPathDocument CreateXPathDocumentFromXmlElement(XmlElement xmlElement)\n{\n    using (XmlNodeReader nodeReader = new XmlNodeReader(xmlElement))\n    {\n        return new XPathDocument(nodeReader);\n    }\n}