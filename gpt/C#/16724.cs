using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string sourcePath = @"C:\path\to\source\file.txt";\n        string destinationPath = @"C:\path\to\destination\file.txt";\n        \n        try\n        {\n            // Ensure that the target does not exist\n            if (File.Exists(destinationPath))\n            {\n                File.Delete(destinationPath);\n            }\n\n            // Copy the file\n            File.Copy(sourcePath, destinationPath);\n            Console.WriteLine("File copied successfully.");\n        }\n        catch (IOException ioExp)\n        {\n            Console.WriteLine(ioExp.Message);\n        }\n    }\n}