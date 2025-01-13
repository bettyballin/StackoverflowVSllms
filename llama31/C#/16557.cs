public void SetPermission(string user, FileSystemRights rights)\n{\n    DirectoryInfo dInfo = new DirectoryInfo(folderPath);\n    DirectorySecurity oDirectorySecurity = new DirectorySecurity();\n\n    FileSystemAccessRule accessRule = new FileSystemAccessRule(\n        user,\n        rights,\n        InheritanceFlags.ContainerInherit | InheritanceFlags.ObjectInherit,\n        PropagationFlags.None,\n        AccessControlType.Allow\n    );\n\n    oDirectorySecurity.AddAccessRule(accessRule);\n    dInfo.SetAccessControl(oDirectorySecurity);\n}