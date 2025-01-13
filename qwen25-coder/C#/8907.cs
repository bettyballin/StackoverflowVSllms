using System.Runtime.Serialization.Json;\nusing System.Text;\n\n[Serializable]\npublic class CanvasObject\n{\n    public double X { get; set; }\n    public double Y { get; set; }\n    public string Content { get; set; } // For text or image source path\n    public int Rotation { get; set; }\n}\n\n// Serialize canvas objects\nprivate string SerializeCanvas(List<CanvasObject> objects)\n{\n    DataContractJsonSerializer serializer = new DataContractJsonSerializer(typeof(List<CanvasObject>));\n    using (var stream = new MemoryStream())\n    {\n        serializer.WriteObject(stream, objects);\n        return Encoding.Default.GetString(stream.ToArray());\n    }\n}\n\n// Deserialize canvas objects\nprivate List<CanvasObject> DeserializeCanvas(string data)\n{\n    DataContractJsonSerializer deserializer = new DataContractJsonSerializer(typeof(List<CanvasObject>));\n    using (var stream = new MemoryStream(Encoding.Default.GetBytes(data)))\n    {\n        return (List<CanvasObject>)deserializer.ReadObject(stream);\n    }\n}