using System;\nusing System.Xml.Linq;\nusing System.Xml.Xsl;\n\nclass Program {\n    static void Main() {\n        // Create XML same as above\n\n        xmlDoc.Save("report.xml");\n\n        XDocument htmlDoc = new XDocument(\n            new XElement("html", new XAttribute(XNamespace.Xmlns + "xhtml", "http://www.w3.org/1999/xhtml"),\n                new XElement("head",\n                    new XElement("title", "Test Report")\n                ),\n                new XElement("body",\n                    new XElement("h1", "Log Entries"),\n                    new XElement("logs",\n                        from log in logs\n                        select new XElement("log",\n                            new XElement("date", log.Date),\n                            new XElement("message", log.Message)\n                        )\n                    )\n                )\n            )\n        );\n\n        XDocument xsltDoc = new XDocument(\n            new XElement(XName.Get("stylesheet", "http://www.w3.org/1999/XSL/Transform"), new XAttribute("version", "1.0"),\n                new XElement(XName.Get("output", "http://www.w3.org/1999/XSL/Transform"), new XAttribute("method", "xml")),\n                new XElement(XName.Get("template", "http://www.w3.org/1999/XSL/Transform"), new XAttribute("match", "/"),\n                    new XElement("html",\n                        new XElement("head",\n                            new XElement("title", "Test Report")\n                        ),\n                        new XElement("body",\n                            new XElement("h1", "Log Entries"),\n                            new XElement("ul",\n                                new XElement(XName.Get("for-each", "http://www.w3.org/1999/XSL/Transform"), new XAttribute("select", "//log"),\n                                    new XElement("li",\n                                        new XElement("span", new XAttribute("class", "date"), new XElement(XName.Get("value-of", "http://www.w3.org/1999/XSL/Transform"), new XAttribute("select", "date"))),\n                                        new XElement("span", new XAttribute("class", "message"), new XElement(XName.Get("value-of", "http://www.w3.org/1999/XSL/Transform"), new XAttribute("select", "message")))\n                                    )\n                                )\n                            )\n                        )\n                    )\n                )\n            )\n        );\n\n        using (var xsltReader = xsltDoc.CreateReader())\n        using (var htmlWriter = new System.IO.StringWriter()) {\n            XslCompiledTransform transform = new XslCompiledTransform();\n            transform.Load(xsltReader);\n            transform.Transform(htmlDoc.CreateReader(), null, htmlWriter);\n\n            System.IO.File.WriteAllText("report.xhtml", htmlWriter.ToString());\n        }\n    }\n}