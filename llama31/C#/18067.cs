foreach (XPathNavigator node in xPathNavigator.Select("//locations/location/cell"))\n{\n    string value = node.Value;\n}