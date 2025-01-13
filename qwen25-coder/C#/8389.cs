using System;\nusing System.IO.Pipes;\nusing System.Text;\nusing System.Threading.Tasks;\n\nclass Program {\n    static async Task Main(string[] args) {\n        var server = new NamedPipeServerStream("MyAppPipe", PipeDirection.InOut);\n        await server.WaitForConnectionAsync();\n        \n        using (var streamReader = new StreamReader(server)) {\n            string command = await streamReader.ReadLineAsync();\n            \n            if (command == "ShowForm") {\n                // Logic to show your form here\n            }\n        }\n\n        server.Disconnect();\n    }\n\n    public static void ShowMainForm() {\n        // Code to show the main form\n        Console.WriteLine("Showing Main Form");\n    }\n}