using System.IO;\nusing System.Security.AccessControl;\n\n// Get the file path\nstring filePath = Server.MapPath("~/YourPage.aspx");\n\n// Get the file's ACL\nFileSecurity fs = File.GetAccessControl(filePath);\n\n// Check if the ASP.NET process has read access\nif (!fs.GetAccessRules(true, true, typeof(System.Security.Principal.NTAccount)).Any(rule => rule.FileSystemRights.HasFlag(FileSystemRights.Read)))\n{\n    // ASP.NET process does not have read access\n}