XmlReader reader = new XmlTextReader(someStream);\nXDocument doc = XDocument.Load(reader);\nXmlNameTable table = reader.NameTable;