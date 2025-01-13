using System;\nusing System.DirectoryServices;\n\npublic class LdapAuthentication\n{\n    private string _path;\n    private string _filterAttribute;\n    \n    public LdapAuthentication(string path)\n    {\n        _path = path;\n    }\n\n    public Object IsAuthenticated(string strDomain, string strUser, string strPass)\n    {\n        string domainAndUsername = strDomain + "\\" + strUser;\n        DirectoryEntry entry = new DirectoryEntry(_path, domainAndUsername, strPass);\n\n        // Set the AuthenticationType explicitly\n        entry.AuthenticationType = AuthenticationTypes.Secure;\n\n        try\n        {\n            // Bind to the native AdsObject to force authentication.\n            object obj = entry.NativeObject;\n\n            DirectorySearcher search = new DirectorySearcher(entry)\n            {\n                Filter = $"(SAMAccountName={strUser})"\n            };\n\n            search.PropertiesToLoad.Add("givenName"); // First Name\n            search.PropertiesToLoad.Add("sn"); // Last Name\n            search.PropertiesToLoad.Add("cn"); // Common Name\n\n            SearchResult result = search.FindOne();\n\n            if (result == null)\n            {\n                return null;\n            }\n\n            // Update the new path to the user in the directory.\n            _path = result.Path;\n            _filterAttribute = result.Properties["cn"][0].ToString();\n        }\n        catch (DirectoryServicesCOMException ex)\n        {\n            // Handle the specific exception for logon failure\n            return new Exception("Logon failure: unknown username or bad password. " + ex.Message);\n        }\n        catch (Exception ex)\n        {\n            // Handle other exceptions\n            return new Exception("Error authenticating user. " + ex.Message);\n        }\n\n        return strUser;\n    }\n}