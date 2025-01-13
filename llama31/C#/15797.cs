using System.Xml.Serialization;\n\n[XmlRoot("MyData")]\npublic class MyData\n{\n    [XmlElement("Name")]\n    public string Name { get; set; }\n\n    [XmlElement("Age")]\n    public int Age { get; set; }\n}\n\npublic class MyWebService\n{\n    public MyData GetData(MyData input)\n    {\n        // Process input data\n        return new MyData { Name = "John", Age = 30 };\n    }\n}\n\n// Client-side code\nMyWebService service = new MyWebService();\nMyData input = new MyData { Name = "Jane", Age = 25 };\nMyData output = service.GetData(input);\n\n// Serialize output to XML\nXmlSerializer serializer = new XmlSerializer(typeof(MyData));\nstring xml = serializer.Serialize(output);