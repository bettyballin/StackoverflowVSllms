XDocument doc = XDocument.Load("file.xml");\nvar dest = doc.Descendants().FirstOrDefault(e => (string)e.Attribute("id") == "ID1");