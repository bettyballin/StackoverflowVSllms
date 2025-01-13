using System;\nusing System.DirectoryServices;\n\nclass Program\n{\n    static void Main()\n    {\n        string userDN = "CN=John Doe,OU=Users,DC=example,DC=com";\n        using (DirectoryEntry user = new DirectoryEntry("LDAP://" + userDN))\n        {\n            try\n            {\n                user.Parent.Children.Remove(user);\n                Console.WriteLine("User has been deleted.");\n            }\n            catch (Exception ex)\n            {\n                Console.WriteLine("An error occurred: " + ex.Message);\n            }\n        }\n    }\n}