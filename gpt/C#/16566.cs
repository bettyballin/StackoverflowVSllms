using System;\nusing System.Linq;\nusing System.Xml.Linq;\n\nclass Program\n{\n    static void Main()\n    {\n        // Define the namespace\n        XNamespace ns = "http://www.w3.org/1999/xhtml";\n        \n        // Sample XML\n        string xmlString = @"<html xmlns='http://www.w3.org/1999/xhtml'>\n                                <head>\n                                    <title>Example</title>\n                                </head>\n                                <body>\n                                    <p>Hello, World!</p>\n                                </body>\n                            </html>";\n\n        // Load the XML\n        XDocument doc = XDocument.Parse(xmlString);\n\n        // Query the XML using the namespace\n        var paragraphs = doc.Descendants(ns + "p");\n\n        foreach (var p in paragraphs)\n        {\n            Console.WriteLine(p.Value);\n        }\n    }\n}