// Example C# code to measure OPC server write and read times\nusing System;\nusing System.Diagnostics;\n\nclass OpcServerPerformanceTest\n{\n    public static void Main(string[] args)\n    {\n        // Replace with actual OPC server and PLC communication code\n        var opcServer = new OpcServer();\n        var plc = new Plc();\n\n        var stopwatch = Stopwatch.StartNew();\n\n        // Write value to PLC through OPC server\n        opcServer.WriteValue("tagName", "value");\n\n        // Read value from PLC through OPC server\n        var value = opcServer.ReadValue("tagName");\n\n        stopwatch.Stop();\n\n        Console.WriteLine($"Time taken: {stopwatch.ElapsedMilliseconds}ms");\n    }\n}