using System.DirectoryServices;\n\npublic bool AuthenticateUser(string ldapHost, string username, string password)\n{\n    try\n    {\n        using (var entry = new DirectoryEntry($"LDAP://{ldapHost}", username, password))\n        {\n            var obj = entry.NativeObject;\n            return true; // Authentication successful\n        }\n    }\n    catch\n    {\n        return false; // Authentication failed\n    }\n}