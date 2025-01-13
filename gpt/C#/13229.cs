using System;\nusing System.DirectoryServices;\nusing System.DirectoryServices.AccountManagement;\n\npublic class ADHelper\n{\n    public static void GetUserInfo(string username)\n    {\n        // Establish a context to the domain\n        using (PrincipalContext context = new PrincipalContext(ContextType.Domain))\n        {\n            // Find the user in the directory\n            UserPrincipal user = UserPrincipal.FindByIdentity(context, username);\n\n            if (user != null)\n            {\n                // Display user information\n                Console.WriteLine($"User: {user.DisplayName}");\n                Console.WriteLine($"Email: {user.EmailAddress}");\n                Console.WriteLine($"Groups:");\n\n                // Iterate through the groups the user is a member of\n                foreach (Principal group in user.GetGroups())\n                {\n                    Console.WriteLine($"  - {group.Name}");\n                }\n            }\n            else\n            {\n                Console.WriteLine($"User {username} not found in AD.");\n            }\n        }\n    }\n}