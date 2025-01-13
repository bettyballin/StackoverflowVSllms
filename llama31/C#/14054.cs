var manager = new XmlNamespaceManager(WorksheetXml.NameTable);\nmanager.AddNamespace("s", @"http://schemas.openxmlformats.org/spreadsheetml/2006/main");\nmanager.AddNamespace("r", @"http://schemas.openxmlformats.org/officeDocument/2006/relationships");\n\nvar nodeList = WorksheetXml.SelectNodes(@"//s:c[child::s:f]", manager);