using System.IO;\nusing System.Security.Permissions;\n\npublic bool HasDeletePermission(string directoryPath)\n{\n    try\n    {\n        FileIOPermission writePermit = new FileIOPermission(FileIOPermissionAccess.Write | FileIOPermissionAccess.PathDiscovery, directoryPath);\n        writePermit.Demand();\n        \n        return true;\n    }\n    catch (SecurityException)\n    {\n        return false;\n    }\n}