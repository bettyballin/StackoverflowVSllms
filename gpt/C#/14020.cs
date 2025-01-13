using System.Net;\n\nclass Program\n{\n    static void Main()\n    {\n        string target = "your-target-name"; // The target name used when storing the credentials\n        NetworkCredential credentials = CredentialManager.GetCredential(target);\n\n        // Assuming WebService1 is your proxy class for the web service\n        WebService1 service = new WebService1();\n        service.Credentials = credentials;\n\n        // Call your web service methods here\n        // Example: service.SomeMethod();\n    }\n}