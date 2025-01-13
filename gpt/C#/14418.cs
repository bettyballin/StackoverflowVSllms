using System.DirectoryServices.AccountManagement;\n\npublic bool IsUserInRole(string username, string role)\n{\n    using (PrincipalContext context = new PrincipalContext(ContextType.Domain))\n    {\n        UserPrincipal user = UserPrincipal.FindByIdentity(context, username);\n        if (user != null)\n        {\n            return user.IsMemberOf(context, IdentityType.Name, role);\n        }\n    }\n    return false;\n}