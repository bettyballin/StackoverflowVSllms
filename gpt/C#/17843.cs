FileStream fileStream = null;\ntry\n{\n    fileStream = new FileStream("example.txt", FileMode.OpenOrCreate);\n    // Use the fileStream object\n    byte[] data = new byte[fileStream.Length];\n    fileStream.Read(data, 0, data.Length);\n    Console.WriteLine(System.Text.Encoding.UTF8.GetString(data));\n}\nfinally\n{\n    if (fileStream != null)\n    {\n        fileStream.Dispose();\n    }\n}