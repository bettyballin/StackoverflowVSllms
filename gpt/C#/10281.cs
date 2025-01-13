public void SetPermission(string folderPath, string user, FileSystemRights rights)\n{\n    DirectoryInfo dInfo = new DirectoryInfo(folderPath);\n    DirectorySecurity dSecurity = dInfo.GetAccessControl();\n\n    // Remove existing rules for the user to avoid duplicates and ensure accuracy\n    AuthorizationRuleCollection rules = dSecurity.GetAccessRules(true, true, typeof(System.Security.Principal.NTAccount));\n    foreach (FileSystemAccessRule rule in rules)\n    {\n        if (rule.IdentityReference.Value.Equals(user, StringComparison.CurrentCultureIgnoreCase))\n        {\n            dSecurity.RemoveAccessRule(rule);\n        }\n    }\n\n    // Add the new access rule\n    dSecurity.AddAccessRule(new FileSystemAccessRule(user, rights, InheritanceFlags.ContainerInherit | InheritanceFlags.ObjectInherit, PropagationFlags.None, AccessControlType.Allow));\n    dInfo.SetAccessControl(dSecurity);\n}