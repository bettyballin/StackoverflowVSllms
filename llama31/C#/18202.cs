XmlReaderSettings settings = new XmlReaderSettings();\nsettings.Schemas.Add(null, xsdFilePath);\nsettings.ValidationType = ValidationType.Schema;\nsettings.ValidationEventHandler += new System.Xml.Schema.ValidationEventHandler(settings_ValidationEventHandler);\nXmlDocument document = new XmlDocument();\ndocument.Load(xmlFilePath);\nXmlReader rdr = XmlReader.Create(new StringReader(document.InnerXml), settings);\n\nwhile (rdr.Read())\n{\n}\n\nbool isValid = true;\n\nvoid settings_ValidationEventHandler(object sender, ValidationEventArgs e)\n{\n    isValid = false;\n    if (e.Exception is XmlSchemaException ex)\n    {\n        Console.WriteLine($"Error at line {ex.LineNumber}, position {ex.LinePosition}: {e.Message}");\n    }\n    else\n    {\n        Console.WriteLine($"Error: {e.Message}");\n    }\n}