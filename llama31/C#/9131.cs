using System.IO;\nusing System.Security.AccessControl;\n\n// ...\n\nvar file = new FileInfo("path/to/file.txt");\nvar acl = file.GetAccessControl();\nacl.AddAccessRule(new FileSystemAccessRule("IIS_IUSRS", FileSystemRights.Read, AccessControlType.Allow));\nfile.SetAccessControl(acl);