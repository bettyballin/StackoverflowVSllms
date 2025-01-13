using System;\nusing System.ServiceModel;\n\nclass Client\n{\n    static void Main(string[] args)\n    {\n        ChannelFactory<IDataService> factory = new ChannelFactory<IDataService>(\n            new BasicHttpBinding(),\n            new EndpointAddress("http://localhost:8080/DataService"));\n\n        IDataService proxy = factory.CreateChannel();\n        string result = proxy.GetData(42);\n        Console.WriteLine(result);\n\n        ((IClientChannel)proxy).Close();\n        factory.Close();\n    }\n}