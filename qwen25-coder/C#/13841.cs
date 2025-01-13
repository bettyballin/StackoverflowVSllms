using System;\nusing System.DirectoryServices.Protocols;\n\npublic class LdapAuthentication\n{\n    public bool Authenticate(string ldapServer, string domain, string username, string password)\n    {\n        var connection = new LdapConnection(new LdapDirectoryIdentifier(ldapServer))\n        {\n            AuthType = AuthType.ServerBind // Explicit credentials needed\n        };\n\n        try\n        {\n            // Bind using the explicit domain and user credentials\n            connection.Bind($"{domain}\\{username}", password);\n\n            // If the bind is successful, return true\n            Console.WriteLine("Authentication succeeded.");\n            return true;\n        }\n        catch (LdapException e)\n        {\n            Console.WriteLine($"Authentication failed: {e.Message}");\n            return false;\n        }\n        finally\n        {\n            connection.Dispose();\n        }\n    }\n}\n\n// Usage example:\nvar authenticator = new LdapAuthentication();\nbool isAuthenticated = authenticator.Authenticate("ldap.testdomain.com", "testdomain", "username", "password");