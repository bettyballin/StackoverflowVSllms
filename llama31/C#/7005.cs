IXPathNavigable[] array = ...; // your array of IXPathNavigable objects\n\nArrayXPathNodeIterator iterator = new ArrayXPathNodeIterator(array);\n\nwhile (iterator.MoveNext())\n{\n    XPathNavigator node = iterator.Current;\n    // process the node\n}