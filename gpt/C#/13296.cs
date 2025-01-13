class Program\n{\n    static void Main(string[] args)\n    {\n        ServiceHost host = new ServiceHost(typeof(ComService), new Uri("http://localhost:8000/ComService"));\n        host.AddServiceEndpoint(typeof(IComService), new BasicHttpBinding(), "");\n        host.Open();\n\n        Console.WriteLine("Service is running...");\n        Console.ReadLine();\n\n        host.Close();\n    }\n}