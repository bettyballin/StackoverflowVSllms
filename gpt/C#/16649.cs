using System;\nusing System.ServiceModel;\nusing System.ServiceModel.Description;\n\n[ServiceContract]\npublic interface IMyService\n{\n    [OperationContract]\n    void SendMessage(string message);\n}\n\npublic class MyService : IMyService\n{\n    public void SendMessage(string message)\n    {\n        Console.WriteLine("Received message: " + message);\n    }\n}\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        Uri baseAddress = new Uri("net.pipe://localhost/MyService");\n        ServiceHost selfHost = new ServiceHost(typeof(MyService), baseAddress);\n\n        try\n        {\n            selfHost.AddServiceEndpoint(typeof(IMyService), new NetNamedPipeBinding(), "MyServiceEndpoint");\n\n            ServiceMetadataBehavior smb = new ServiceMetadataBehavior();\n            smb.HttpGetEnabled = false;\n            selfHost.Description.Behaviors.Add(smb);\n\n            selfHost.Open();\n            Console.WriteLine("The service is ready.");\n\n            Console.WriteLine("Press <Enter> to terminate the service.");\n            Console.ReadLine();\n\n            selfHost.Close();\n        }\n        catch (CommunicationException ce)\n        {\n            Console.WriteLine("An exception occurred: {0}", ce.Message);\n            selfHost.Abort();\n        }\n    }\n}