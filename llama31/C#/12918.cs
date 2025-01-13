using System;\nusing System.Security.Principal;\nusing System.DirectoryServices.AccountManagement;\n\npublic bool IsUserAdministrator(string userName)\n{\n    using (PrincipalContext context = new PrincipalContext(ContextType.Machine))\n    {\n        UserPrincipal user = UserPrincipal.FindByIdentity(context, userName);\n        if (user != null)\n        {\n            PrincipalSearchResult<Principal> groups = user.GetAuthorizationGroups();\n            foreach (Principal group in groups)\n            {\n                if (group.Name == "Administrators")\n                {\n                    return true;\n                }\n            }\n        }\n    }\n    return false;\n}