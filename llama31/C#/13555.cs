XNamespace xhtml = "http://www.w3.org/1999/xhtml";\nXNamespace otherNs = "http://example.com/other-namespace";\nvar x = xDoc.Descendants(xhtml + "div")\n            .Concat(xDoc.Descendants(otherNs + "div"));