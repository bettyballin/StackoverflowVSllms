class Program\n{\n    static void Main(string[] args)\n    {\n        ChannelFactory<IMyService> factory = new ChannelFactory<IMyService>(new BasicHttpBinding(), new EndpointAddress("http://yourserviceurl"));\n        IMyService client = factory.CreateChannel();\n\n        XmlElement xmlData = client.GetXmlData();\n\n        // Process the XML data as needed\n        Console.WriteLine(xmlData.OuterXml);\n    }\n}