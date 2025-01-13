using System;\nusing System.Configuration;\nusing System.IO;\nusing System.Text;\n\npublic class TestConfig\n{\n    public static Configuration LoadConfigurationFromXml(string xml)\n    {\n        var xmlDoc = new XmlDocument();\n        xmlDoc.LoadXml(xml);\n\n        var stream = new MemoryStream();\n        xmlDoc.Save(stream);\n        stream.Position = 0;\n\n        var config = ConfigurationManager.OpenMappedExeConfiguration(\n            new ExeConfigurationFileMap { ExeConfigFilename = "dummy.exe.config" },\n            ConfigurationUserLevel.None);\n\n        config.Save(ConfigurationSaveMode.Full);\n        config = ConfigurationManager.OpenMappedExeConfiguration(\n            new ExeConfigurationFileMap { ExeConfigFilename = "dummy.exe.config" },\n            ConfigurationUserLevel.None);\n\n        using (var reader = new StreamReader(stream))\n        {\n            var serializer = new XmlSerializer(typeof(Configuration));\n            return serializer.Deserialize(reader) as Configuration;\n        }\n    }\n}