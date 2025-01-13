using System;\nusing System.DirectoryServices.AccountManagement;\nusing System.Security.Principal;\n\npublic class SidToAccountNameConverter\n{\n    public static string GetNameFromSID(SecurityIdentifier sid)\n    {\n        // Create a PrincipalContext to a domain controller (use null for the current user's domain)\n        using (var context = new PrincipalContext(ContextType.Domain, null))\n        {\n            // Try to find a user or group by SID\n            var user = UserPrincipal.FindByIdentity(context, IdentityType.Sid, sid.ToString());\n            if (user != null) return user.Name;\n\n            var group = GroupPrincipal.FindByIdentity(context, IdentityType.Sid, sid.ToString());\n            if (group != null) return group.Name;\n        }\n\n        // If no match found in domain, try local machine\n        NTAccount ntAccount = (NTAccount)sid.Translate(typeof(NTAccount));\n        return ntAccount.Value;\n    }\n}