using System.ServiceModel;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        ServiceHost host = new ServiceHost(typeof(ServiceRegistry), new Uri("http://localhost:8080/ServiceRegistry"));\n        host.AddServiceEndpoint(typeof(IServiceRegistry), new BasicHttpBinding(), "");\n        host.Open();\n\n        Console.WriteLine("Service Registry is running...");\n        Console.ReadLine();\n\n        host.Close();\n    }\n}