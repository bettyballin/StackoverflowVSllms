using System;\nusing System.DirectoryServices;\n\npublic class LdapConnectionCheck\n{\n    public static bool IsConnected(string ldapPath, string username, string password)\n    {\n        using (var entry = new DirectoryEntry(ldapPath, username, password))\n        {\n            try\n            {\n                // Perform a simple search that doesn't modify the directory.\n                var searcher = new DirectorySearcher(entry) { Filter = "(objectClass=*)" };\n                searcher.FindOne();  // This will throw if not connected\n\n                return true;\n            }\n            catch (Exception ex)\n            {\n                // Log or handle the exception as needed\n                Console.WriteLine("LDAP Connection failed: " + ex.Message);\n                return false;\n            }\n        }\n    }\n\n    public static void Main()\n    {\n        string ldapPath = "LDAP://your-ldap-server";\n        string username = "your-username";\n        string password = "your-password";\n\n        bool isConnected = IsConnected(ldapPath, username, password);\n\n        Console.WriteLine("Is connected: " + isConnected);\n    }\n}