using System;\nusing System.DirectoryServices;\n\nclass Program\n{\n    static void Main()\n    {\n        string ldapConnection = "LDAP://DC=yourdomain,DC=com";\n        DirectoryEntry de = new DirectoryEntry(ldapConnection);\n        \n        // This will automatically connect to a domain controller hosting LDAP\n        foreach (object obj in de.Children)\n        {\n            Console.WriteLine(obj);\n        }\n    }\n}