public void MyMethod(int param1, string param2)\n{\n    LogEntry("MyMethod", new { Param1 = param1, Param2 = param2 });\n    \n    try\n    {\n        // Method implementation\n    }\n    catch (Exception ex)\n    {\n        LogException(ex);\n        throw;\n    }\n}\n\nprivate void LogEntry(string methodName, object parameters)\n{\n    Console.WriteLine($"Entering method: {methodName} with params: {JsonConvert.SerializeObject(parameters)}");\n}\n\nprivate void LogException(Exception ex)\n{\n    Console.WriteLine $"Exception occurred: {ex.Message}");\n}