using System;\nusing System.ServiceModel;\nusing System.ServiceModel.Web;\n\nnamespace YourNamespace\n{\n    [ServiceContract]\n    public interface IYourService\n    {\n        // Example of a RESTful GET operation\n        [OperationContract]\n        [WebGet(UriTemplate = "/data", ResponseFormat = WebMessageFormat.Json)]\n        string GetData();\n\n        // Example of a RESTful POST operation\n        [OperationContract]\n        [WebInvoke(UriTemplate = "/data", Method = "POST")]\n        void AddData(string data);\n    }\n\n    public class YourService : IYourService\n    {\n        public string GetData()\n        {\n            return "{\"message\": \"Hello, World!\"}";\n        }\n\n        public void AddData(string data)\n        {\n            // Implementation for adding data\n        }\n    }\n\n    class Program\n    {\n        static void Main(string[] args)\n        {\n            Uri baseAddress = new Uri("http://localhost:8000/");\n            \n            using (WebServiceHost host = new WebServiceHost(typeof(YourService), baseAddress))\n            {\n                host.Open();\n                Console.WriteLine("Service is running...");\n                Console.ReadLine();\n\n                // Close the service when done\n                host.Close();\n            }\n        }\n    }\n}