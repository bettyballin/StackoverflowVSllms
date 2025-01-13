using System;\nusing System.DirectoryServices;\n\npublic class ADStatusChecker\n{\n    public static bool IsADServerAlive(string ldapPath)\n    {\n        try\n        {\n            using (var entry = new DirectoryEntry(ldapPath))\n            {\n                // Access the native object to force a bind attempt\n                var nativeObject = entry.NativeObject;\n            }\n            return true; // Server is up and running.\n        }\n        catch (Exception ex)\n        {\n            // Log or handle exception if needed.\n            Console.WriteLine($"Error: {ex.Message}");\n            return false; // Server could not be reached.\n        }\n    }\n\n    public static void Main()\n    {\n        string ldapPath = "LDAP://YourADServerDomain"; // Replace with your AD server's LDAP path\n        bool isAlive = IsADServerAlive(ldapPath);\n        Console.WriteLine($"Is the AD server alive? {isAlive}");\n    }\n}