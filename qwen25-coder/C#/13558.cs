// Example of consuming the service\nAccessDatabaseWrapperService.AccessDatabaseWrapperClient client = \n    new AccessDatabaseWrapperService.AccessDatabaseWrapperClient();\nList<string> data = client.GetData();\n\nforeach (string item in data)\n{\n    Console.WriteLine(item);\n}