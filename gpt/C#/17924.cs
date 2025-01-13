using System;\nusing System.Security.Principal;\n\nclass Program\n{\n    static void Main()\n    {\n        WindowsIdentity identity = WindowsIdentity.GetCurrent();\n        SecurityIdentifier userSid = identity.User;\n        string userName = identity.Name;\n\n        Console.WriteLine("User SID: " + userSid.Value);\n        Console.WriteLine("Username: " + userName);\n    }\n}