XmlDocument doc = new XmlDocument();\ndoc.Load("yourxmlfile.xml");\n\nXmlNamespaceManager nsMgr = new XmlNamespaceManager(doc.NameTable);\nnsMgr.AddNamespace("ink", "http://www.inktomi.com/");\n\nXmlNodeList nodes = doc.SelectNodes("//ink:result", nsMgr);