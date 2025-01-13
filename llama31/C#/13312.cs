using System.DirectoryServices;\n\npublic class AdHelper\n{\n    public static (string domainName, string userName) GetDomainAndUserName(string email)\n    {\n        using var directoryEntry = new DirectoryEntry("LDAP://rootDSE");\n        using var directorySearcher = new DirectorySearcher(directoryEntry);\n\n        directorySearcher.Filter = $"(&(objectClass=user)(mail={email}))";\n        directorySearcher.PropertiesToLoad.Add("distinguishedName");\n        directorySearcher.PropertiesToLoad.Add("samAccountName");\n\n        var searchResult = directorySearcher.FindOne();\n\n        if (searchResult != null)\n        {\n            var distinguishedName = searchResult.Properties["distinguishedName"][0].ToString();\n            var domainName = distinguishedName.Split(',')[0].Split('=')[1];\n            var userName = searchResult.Properties["samAccountName"][0].ToString();\n\n            return (domainName, userName);\n        }\n\n        return (null, null);\n    }\n}