using System;\nusing System.IO.Pipes;\nusing System.Text;\n\npublic class NamedPipeServer : IDisposable\n{\n    private NamedPipeServerStream _pipeServer;\n\n    public void StartPipe()\n    {\n        _pipeServer = new NamedPipeServerStream("testpipe", PipeDirection.InOut, 1);\n        Console.WriteLine("Named pipe server started. Waiting for client to connect...");\n\n        _pipeServer.WaitForConnection();\n        Console.WriteLine("Client connected.");\n\n        // Sending message to client\n        using (StreamWriter writer = new StreamWriter(_pipeServer) { AutoFlush = true })\n        {\n            writer.WriteLine("Hello from server.");\n        }\n    }\n\n    public void Dispose()\n    {\n        _pipeServer.Close();\n    }\n}\n\npublic class NamedPipeClient : IDisposable\n{\n    private NamedPipeClientStream _pipeClient;\n\n    public void Connect(string pipeName)\n    {\n        Console.WriteLine("Connecting to named pipe server...");\n        _pipeClient = new NamedPipeClientStream(".", pipeName, PipeDirection.In);\n        _pipeClient.Connect();\n        Console.WriteLine("Connection established.");\n\n        // Receiving message from server\n        using (StreamReader reader = new StreamReader(_pipeClient))\n        {\n            string message = reader.ReadLine();\n            Console.WriteLine($"Server says: {message}");\n        }\n    }\n\n    public void Dispose()\n    {\n        _pipeClient.Close();\n    }\n}