public static void SetPermissions(string dir)\n{\n    DirectoryInfo info = new DirectoryInfo(dir);\n    DirectorySecurity ds = info.GetAccessControl();\n\n    ds.AddAccessRule(new FileSystemAccessRule(@"BUILTIN\Users",\n                         FileSystemRights.FullControl,\n                         InheritanceFlags.ObjectInherit | InheritanceFlags.ContainerInherit,\n                         PropagationFlags.InheritOnly,\n                         AccessControlType.Allow));\n\n    info.SetAccessControl(ds);\n}