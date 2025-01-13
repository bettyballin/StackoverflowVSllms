using System;\nusing Microsoft.SharePoint.Client;\n\nnamespace SharePointPermissionExample\n{\n    class Program\n    {\n        static void Main(string[] args)\n        {\n            string siteUrl = "https://yoursharepointsiteurl";\n            string listTitle = "YourListTitle";\n            string userEmail = "user@example.com"; // The email of the user or group\n\n            // ClientContext with your SharePoint site URL\n            using (ClientContext clientContext = new ClientContext(siteUrl))\n            {\n                // Provide authentication (use appropriate authentication method)\n                clientContext.Credentials = new SharePointOnlineCredentials("yourusername@domain.com", GetSecureString("yourpassword"));\n\n                // Get the user or group\n                User user = clientContext.Web.EnsureUser(userEmail);\n                clientContext.Load(user);\n                clientContext.ExecuteQuery();\n\n                // Get the list\n                List list = clientContext.Web.Lists.GetByTitle(listTitle);\n                clientContext.Load(list, l => l.HasUniqueRoleAssignments);\n                clientContext.ExecuteQuery();\n\n                // Break role inheritance if it is not already broken\n                if (!list.HasUniqueRoleAssignments)\n                {\n                    list.BreakRoleInheritance(true, false);\n                    clientContext.ExecuteQuery();\n                }\n\n                // Get the "Contribute" role definition\n                RoleDefinition contributeRoleDefinition = clientContext.Web.RoleDefinitions.GetByName("Contribute");\n                clientContext.Load(contributeRoleDefinition);\n                clientContext.ExecuteQuery();\n\n                // Create a role assignment\n                RoleDefinitionBindingCollection roleBindings = new RoleDefinitionBindingCollection(clientContext);\n                roleBindings.Add(contributeRoleDefinition);\n\n                // Add the role assignment to the list\n                list.RoleAssignments.Add(user, roleBindings);\n                clientContext.ExecuteQuery();\n\n                Console.WriteLine("Permission added successfully.");\n            }\n        }\n\n        // Helper method to get a SecureString from plain text password\n        private static System.Security.SecureString GetSecureString(string password)\n        {\n            var secureString = new System.Security.SecureString();\n            foreach (char c in password)\n            {\n                secureString.AppendChar(c);\n            }\n            secureString.MakeReadOnly();\n            return secureString;\n        }\n    }\n}