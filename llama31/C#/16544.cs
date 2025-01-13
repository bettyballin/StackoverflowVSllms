using System.Xml;\n\n// ...\n\nXmlDocument doc = new XmlDocument();\n// ... populate the XmlDocument object ...\n\nusing (XmlReader reader = XmlReader.Create(new StringReader(doc.InnerXml)))\n{\n    reader.Settings.CheckCharacters = false; // ignore invalid characters\n    string xml = reader.ReadOuterXml();\n    // use the xml string to insert into your database\n}