using System;\nusing System.IO.Pipes;\n\npublic class PipeClient\n{\n    public static void Main(string[] args)\n    {\n        using (NamedPipeClientStream pipeClient = new NamedPipeClientStream(".", "testpipe", PipeDirection.In))\n        {\n            Console.WriteLine("Trying to connect...");\n\n            pipeClient.Connect(); \n\n            using (StreamReader sr = new StreamReader(pipeClient))\n            {\n                string messageReceived = sr.ReadLine();\n                int receivedInt;\n                if (int.TryParse(messageReceived, out receivedInt))\n                {\n                    Console.WriteLine($"Received number: {receivedInt}");\n                }\n                else\n                {\n                    Console.WriteLine("Failed to parse the received message as an integer.");\n                }\n            }\n        }\n    }\n}