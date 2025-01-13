DirectoryInfo dirInfo = new DirectoryInfo("C:\\TestDir2");\n            DirectorySecurity dirSecurity = dirInfo.GetAccessControl();\n\n            dirSecurity.AddAccessRule(new FileSystemAccessRule("ASPNET", FileSystemRights.Write|FileSystemRights.DeleteSubdirectoriesAndFiles, InheritanceFlags.ContainerInherit | InheritanceFlags.ObjectInherit, PropagationFlags.InheritOnly, AccessControlType.Allow));\n\n\n            dirInfo.SetAccessControl(dirSecurity); 