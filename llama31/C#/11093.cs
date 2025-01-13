string file = Path.GetTempFileName(); // pretend this is a real file\nstring tmpFile = Path.GetTempFileName();\n\nusing (var fs = File.Create(tmpFile))\nusing (var writer = XmlWriter.Create(fs))\n{\n    writer.WriteStartElement("root");\n    for (int i = 0; i < 100; i++)\n    {\n        writer.WriteElementString("test", null, \n            "All work and no play makes Jack a dull boy");\n    }\n    writer.WriteEndElement();\n}\n\nFile.Delete(file);\nFile.Move(tmpFile, file);