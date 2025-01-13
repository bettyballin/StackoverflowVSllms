using System;\nusing System.IO.Pipes;\nusing System.Text;\n\nclass Program\n{\n    static void Main()\n    {\n        using (var pipeClient = new NamedPipeClientStream(".", "YourPipeName", PipeDirection.Out))\n        {\n            pipeClient.Connect();\n            using (var writer = new StreamWriter(pipeClient))\n            {\n                writer.AutoFlush = true;\n                writer.WriteLine("Message to 32-bit surrogate");\n            }\n        }\n    }\n}