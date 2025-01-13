// Server process (e.g., running .NET 3.5)\nusing System;\nusing System.IO;\nusing System.IO.Pipes;\n\nclass Server\n{\n    static void Main()\n    {\n        using (NamedPipeServerStream pipeServer = new NamedPipeServerStream("TestPipe", PipeDirection.Out))\n        {\n            Console.WriteLine("NamedPipeServerStream object created.");\n\n            // Wait for a client to connect\n            pipeServer.WaitForConnection();\n            Console.WriteLine("Client connected.");\n\n            using (StreamWriter writer = new StreamWriter(pipeServer))\n            {\n                writer.AutoFlush = true;\n                writer.WriteLine("Hello from .NET 3.5 server!");\n            }\n        }\n    }\n}\n\n// Client process (e.g., running .NET 1.1)\nusing System;\nusing System.IO;\nusing System.IO.Pipes;\n\nclass Client\n{\n    static void Main()\n    {\n        using (NamedPipeClientStream pipeClient = new NamedPipeClientStream(".", "TestPipe", PipeDirection.In))\n        {\n            pipeClient.Connect();\n            using (StreamReader reader = new StreamReader(pipeClient))\n            {\n                string message = reader.ReadLine();\n                Console.WriteLine("Received from server: " + message);\n            }\n        }\n    }\n}