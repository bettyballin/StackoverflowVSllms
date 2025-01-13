using System;\nusing System.IO;\nusing System.Security.AccessControl;\nusing System.Security.Principal;\n\nclass Program\n{\n    static void Main()\n    {\n        // Define the file path\n        string filePath = @"C:\path\to\your\file.txt";\n\n        // Get the current FileSecurity\n        FileSecurity fileSecurity = File.GetAccessControl(filePath);\n\n        // Define a new rule\n        FileSystemAccessRule newRule = new FileSystemAccessRule(\n            new NTAccount("DOMAIN", "User"),\n            FileSystemRights.Read | FileSystemRights.Write,\n            AccessControlType.Allow);\n\n        // Add the new rule to the file\n        fileSecurity.AddAccessRule(newRule);\n\n        // Set the updated FileSecurity back to the file\n        File.SetAccessControl(filePath, fileSecurity);\n\n        Console.WriteLine("Permissions updated successfully.");\n    }\n}