string file = HttpContext.Current.Server.MapPath("~/XML/Locations.xml");\n\nDictionary<string, Location> locationCollection = new Dictionary<string, Location>();\n\nXPathDocument xDocument = new XPathDocument(file);\nXPathNavigator xPathNavigator = xDocument.CreateNavigator();\n\nforeach (XPathNavigator node in xPathNavigator.Select("//locations/location")) // Adjusted the XPath query to select 'location' elements\n{\n    string value = node.SelectSingleNode("cell").Value; // Use relative XPath expression\n    // You can now use 'value' and other properties to populate your dictionary\n}