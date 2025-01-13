using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string fileName = "cheese.exe";\n        string startDirectory = @"C:\"; // Starting directory for the search\n\n        try\n        {\n            string result = FindFile(startDirectory, fileName);\n            if (result != null)\n            {\n                Console.WriteLine($"File found at: {result}");\n            }\n            else\n            {\n                Console.WriteLine("File not found.");\n            }\n        }\n        catch (UnauthorizedAccessException e)\n        {\n            Console.WriteLine($"Access denied to a directory: {e.Message}");\n        }\n        catch (Exception e)\n        {\n            Console.WriteLine($"An error occurred: {e.Message}");\n        }\n    }\n\n    static string FindFile(string directory, string fileName)\n    {\n        try\n        {\n            foreach (string file in Directory.GetFiles(directory))\n            {\n                if (Path.GetFileName(file).Equals(fileName, StringComparison.OrdinalIgnoreCase))\n                {\n                    return file;\n                }\n            }\n\n            foreach (string subDirectory in Directory.GetDirectories(directory))\n            {\n                string result = FindFile(subDirectory, fileName);\n                if (result != null)\n                {\n                    return result;\n                }\n            }\n        }\n        catch (UnauthorizedAccessException)\n        {\n            // Handle the case where the program does not have access to a directory\n        }\n        catch (DirectoryNotFoundException)\n        {\n            // Handle the case where a directory was deleted during the search\n        }\n\n        return null;\n    }\n}