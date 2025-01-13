XmlSchema schema;\nusing (var schemaStreamReader = XmlReader.Create(schemaStream))\n{\n    schema = XmlSchema.Read(schemaStreamReader, ValidationEventHandler);\n}\n\nXmlReaderSettings xmlReaderSettings = new XmlReaderSettings\n{\n    ValidationType = ValidationType.Schema\n};\nxmlReaderSettings.Schemas.Add(schema);\nxmlReaderSettings.ValidationEventHandler += ValidationEventHandler;\n\nusing (var xmlReader = XmlReader.Create(xmlStream, xmlReaderSettings))\n{\n    while (xmlReader.Read()) { }\n}\n\nprivate void ValidationEventHandler(object sender, ValidationEventArgs args)\n{\n    if (args.Severity == XmlSeverityType.Warning)\n    {\n        Console.WriteLine($"Warning: {args.Message}");\n    }\n    else if (args.Severity == XmlSeverityType.Error)\n    {\n        Console.WriteLine($"Error: {args.Message}");\n        _IsValid = false;\n    }\n}