using System;\nusing System.Xml;\nusing System.Xml.Schema;\nusing System.Xml.Serialization;\n\npublic class Root : IXmlSerializable\n{\n    public bool Emulate { get; set; }\n\n    public XmlSchema GetSchema() => null;\n\n    public void ReadXml(XmlReader reader)\n    {\n        reader.MoveToContent();\n        Emulate = reader.ReadElementContentAsString() == "1";\n    }\n\n    public void WriteXml(XmlWriter writer)\n    {\n        writer.WriteElementString("emulate", Emulate ? "1" : "0");\n    }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        var root = new Root { Emulate = true };\n\n        // Serialize\n        var xmlSerializer = new XmlSerializer(typeof(Root));\n        using (var stringWriter = new System.IO.StringWriter())\n        {\n            using (var xmlWriter = XmlWriter.Create(stringWriter))\n            {\n                xmlSerializer.Serialize(xmlWriter, root);\n                Console.WriteLine(stringWriter.ToString());\n            }\n        }\n\n        // Deserialize\n        var xml = "<root><emulate>1</emulate></root>";\n        using (var stringReader = new System.IO.StringReader(xml))\n        {\n            var deserializedRoot = (Root)xmlSerializer.Deserialize(stringReader);\n            Console.WriteLine(deserializedRoot.Emulate); // Output: True\n        }\n    }\n}