using System;\nusing System.DirectoryServices.AccountManagement;\n\npublic class Program\n{\n    public static void Main()\n    {\n        string domainName = "yourdomain";\n        string groupName = "GROUPNAME";\n        string userName = "username";\n\n        try\n        {\n            using (PrincipalContext ctx = new PrincipalContext(ContextType.Domain, domainName))\n            {\n                GroupPrincipal group = GroupPrincipal.FindByIdentity(ctx, groupName);\n                if (group != null)\n                {\n                    UserPrincipal user = UserPrincipal.FindByIdentity(ctx, userName);\n                    if (user != null)\n                    {\n                        group.Members.Add(user);\n                        group.Save();\n                        Console.WriteLine("User added to group successfully.");\n                    }\n                    else\n                    {\n                        Console.WriteLine("User not found.");\n                    }\n                }\n                else\n                {\n                    Console.WriteLine("Group not found.");\n                }\n            }\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Error: " + ex.Message);\n        }\n    }\n}