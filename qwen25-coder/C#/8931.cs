using System;\nusing System.Data.OleDb;\n\nclass Program\n{\n    static void Main()\n    {\n        bool isJetProviderAvailable = false;\n\n        // Create an instance of OleDbEnumerator to discover installed data providers.\n        using (DataTable providers = OleDbEnumerator.GetRootEnumerator())\n        {\n            foreach (DataRow row in providers.Rows)\n            {\n                string providerName = row["PROVIDER"]?.ToString();\n                Console.WriteLine($"Installed Provider: {providerName}");\n\n                if (providerName == "Microsoft.Jet.OLEDB.4.0")\n                {\n                    isJetProviderAvailable = true;\n                }\n            }\n        }\n\n        Console.WriteLine("\nIs Microsoft.Jet.OLEDB.4.0 provider installed? " + \n                          $"{(isJetProviderAvailable ? "Yes" : "No")}");\n    }\n}