using System;\nusing System.IO;\nusing System.Security.AccessControl;\nusing System.Security.Principal;\nusing System.Text;\n\npublic class ACLChecker\n{\n    public void CheckSecurity(DirectoryInfo[] DIArray)\n    {\n        foreach (DirectoryInfo di in DIArray)\n        {\n            try\n            {\n                DirectorySecurity DirSec = di.GetAccessControl(AccessControlSections.Access);\n                string sAccessInfo = string.Empty;\n\n                foreach (FileSystemAccessRule FSAR in DirSec.GetAccessRules(true, true, typeof(NTAccount)))\n                {\n                    sAccessInfo += GetAceInformation(FSAR);\n                }\n\n                if (!string.IsNullOrEmpty(sAccessInfo))\n                {\n                    // Write info to text file\n                    // Example: File.AppendAllText("output.txt", sAccessInfo);\n                }\n            }\n            catch (UnauthorizedAccessException ex)\n            {\n                Console.WriteLine($"Access denied for directory: {di.FullName}. Exception: {ex.Message}");\n            }\n            catch (Exception ex)\n            {\n                Console.WriteLine($"Error processing directory: {di.FullName}. Exception: {ex.Message}");\n            }\n        }\n    }\n\n    private string GetAceInformation(FileSystemAccessRule ace)\n    {\n        var info = new StringBuilder();\n        info.AppendLine($"Account: {ace.IdentityReference.Value}");\n        info.AppendLine($"Type: {ace.AccessControlType}");\n        info.AppendLine($"Rights: {ace.FileSystemRights}");\n        info.AppendLine($"Inherited ACE: {ace.IsInherited}");\n        return info.ToString();\n    }\n}