using System;\nusing System.Security.Principal;\nusing Microsoft.SharePoint;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        Console.WriteLine("Current identity: " + WindowsIdentity.GetCurrent().Name);\n\n        SPSecurity.RunWithElevatedPrivileges(delegate\n        {\n            Console.WriteLine("Elevated identity: " + WindowsIdentity.GetCurrent().Name);\n        });\n    }\n}