using System;\nusing System.DirectoryServices;\n\npublic class ActiveDirectoryHelper\n{\n    public static bool ValidateExpiredPassword(string ldapPath, string username, string password)\n    {\n        try\n        {\n            using (DirectoryEntry entry = new DirectoryEntry(ldapPath, username, password))\n            {\n                // Force authentication by accessing a property\n                object nativeObject = entry.NativeObject;\n            }\n            return true; // Authentication successful\n        }\n        catch (DirectoryServicesCOMException ex)\n        {\n            if (ex.ExtendedErrorMessage.Contains("LDAP: error code 49 - 80090308: LdapErr: DSID-0C090334"))\n            {\n                // Password expired error\n                return true;\n            }\n            return false; // Authentication failed\n        }\n        catch (Exception)\n        {\n            return false; // Authentication failed\n        }\n    }\n}\n\n// Usage\nstring ldapPath = "LDAP://yourdomain.com";\nstring username = "yourusername";\nstring password = "youroldpassword";\n\nbool isValid = ActiveDirectoryHelper.ValidateExpiredPassword(ldapPath, username, password);\nConsole.WriteLine("Is valid: " + isValid);