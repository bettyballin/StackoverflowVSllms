public class MyService : IMyService\n{\n    public string SendMessage(string message)\n    {\n        // Implement your logic to interact with the external system over TCP/IP\n        return "Received: " + message;\n    }\n}