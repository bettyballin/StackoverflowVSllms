// Assume WorksheetXml is already loaded as XmlDocument\nvar manager = new XmlNamespaceManager(WorksheetXml.NameTable);\nmanager.AddNamespace("x", @"http://schemas.openxmlformats.org/spreadsheetml/2006/main");\n\nvar nodeList = WorksheetXml.SelectNodes(@"//x:c[child::x:f]", manager);\n\nif (nodeList != null)\n{\n    foreach (XmlNode node in nodeList)\n    {\n        // Process each node here\n        Console.WriteLine(node.OuterXml);\n    }\n}\nelse\n{\n    Console.WriteLine("No nodes found.");\n}