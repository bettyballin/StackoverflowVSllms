using System.Security.Permissions;\n\nPermissionSet permissionSet = new PermissionSet(PermissionState.Unrestricted);\npermissionSet.AddPermission(new FileIOPermission(FileIOPermissionAccess.Read, @"\\network\share"));\npermissionSet.Assert();