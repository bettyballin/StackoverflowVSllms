using System;\nusing System.ServiceModel;\nusing System.ServiceModel.Description;\n\nnamespace WCFStatistics\n{\n    public class Program\n    {\n        public static void Main(string[] args)\n        {\n            Uri baseAddress = new Uri("http://localhost:8000/ServiceModelSamples/Service");\n            ServiceHost selfHost = new ServiceHost(typeof(MyService), baseAddress);\n\n            try\n            {\n                selfHost.AddServiceEndpoint(typeof(IMyService), new WSHttpBinding(), "MyService");\n\n                ServiceMetadataBehavior smb = new ServiceMetadataBehavior();\n                smb.HttpGetEnabled = true;\n                selfHost.Description.Behaviors.Add(smb);\n\n                selfHost.Open();\n\n                // Retrieve performance counters\n                var counters = selfHost.ChannelDispatchers[0].Listener.GetType()\n                    .GetProperty("PerformanceCounters", System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance)\n                    .GetValue(selfHost.ChannelDispatchers[0].Listener, null);\n\n                foreach (var counter in counters.GetType().GetProperties())\n                {\n                    Console.WriteLine($"{counter.Name}: {counter.GetValue(counters, null)}");\n                }\n\n                Console.WriteLine("The service is ready.");\n                Console.WriteLine("Press <ENTER> to terminate service.");\n                Console.ReadLine();\n\n                selfHost.Close();\n            }\n            catch (CommunicationException ce)\n            {\n                Console.WriteLine($"An exception occurred: {ce.Message}");\n                selfHost.Abort();\n            }\n        }\n    }\n\n    [ServiceContract]\n    public interface IMyService\n    {\n        [OperationContract]\n        string GetData(int value);\n    }\n\n    public class MyService : IMyService\n    {\n        public string GetData(int value)\n        {\n            return $"You entered: {value}";\n        }\n    }\n}