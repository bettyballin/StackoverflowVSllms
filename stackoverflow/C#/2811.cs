XPathDocument doc = new XPathDocument(@"c:\filepath\doc.xml");\nXPathNavigator nav = doc.CreateNavigator();\nXPathNodeIterator iter = nav.Select("/xpath/query/here");\n\nwhile(iter->MoveNext)\n{\n  //Do something with node here.\n}