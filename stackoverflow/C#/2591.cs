XDocument doc = XDocument.Load("foo.xml");\nXNamespace ns = "bar";\nvar results = doc.Descendants(ns + "result");\n\nforeach (var result in results)\n{\n    ...\n}