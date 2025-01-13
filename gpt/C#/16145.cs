using System.Security.Permissions;\n\n   public void WriteToFile(string filePath, string content)\n   {\n       FileIOPermission permission = new FileIOPermission(FileIOPermissionAccess.Write, filePath);\n       permission.Demand();\n\n       // Code to write to the file\n       System.IO.File.WriteAllText(filePath, content);\n   }