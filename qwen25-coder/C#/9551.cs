using System;\nusing System.Xml.Serialization;\n\npublic class Root {\n    public string Item { get; set; }\n}\n\npublic class DeserializeExample {\n    public static void Main() {\n        string xmlContent = @"<Root><Item>Value</Item></Root>";\n        XmlSerializer serializer = new XmlSerializer(typeof(Root));\n        using (System.IO.StringReader reader = new System.IO.StringReader(xmlContent)) {\n            Root root = (Root)serializer.Deserialize(reader);\n            Console.WriteLine(root.Item); // Output: Value\n        }\n    }\n}