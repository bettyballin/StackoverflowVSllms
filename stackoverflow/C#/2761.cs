XmlDocument doc = new XmlDocument();\ndoc.LoadXml(xmlWithBogusNamespace);            \nXmlNamespaceManager nSpace = new XmlNamespaceManager(doc.NameTable);\nnSpace.AddNamespace("myNs", "http://theirUri");\n\nXmlNodeList nodes = doc.SelectNodes("//myNs:NodesIWant",nSpace);\n//etc