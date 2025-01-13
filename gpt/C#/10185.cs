using System;\n   using System.ServiceModel;\n\n   class Program\n   {\n       static void Main(string[] args)\n       {\n           using (ServiceHost host = new ServiceHost(typeof(MyService), new Uri("http://localhost:8000/MyService")))\n           {\n               host.AddServiceEndpoint(typeof(IMyService), new BasicHttpBinding(), "");\n               host.Open();\n\n               Console.WriteLine("Service is running...");\n               Console.ReadLine();\n\n               host.Close();\n           }\n       }\n   }