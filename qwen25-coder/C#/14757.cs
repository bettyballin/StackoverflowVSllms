using System;\nusing System.DirectoryServices;\n\npublic class ActiveDirectoryHelper\n{\n    public static bool IsUserActive(string userName)\n    {\n        using (var searcher = new DirectorySearcher())\n        {\n            // Set the filter to find the user by sAMAccountName\n            searcher.Filter = $"(sAMAccountName={userName})";\n            \n            // Only retrieve the userAccountControl property\n            searcher.PropertiesToLoad.Add("userAccountControl");\n\n            var result = searcher.FindOne();\n            if (result != null)\n            {\n                int accountControlValue = Convert.ToInt32(result.Properties["userAccountControl"][0]);\n\n                // Check if the UF_ACCOUNTDISABLE flag is set\n                const int ACCOUNT_DISABLED = 0x2;\n                bool isDisabled = ((accountControlValue & ACCOUNT_DISABLED) == ACCOUNT_DISABLED);\n\n                return !isDisabled; // Return true if not disabled\n            }\n        }\n\n        // If no user was found, consider it inactive\n        return false;\n    }\n}