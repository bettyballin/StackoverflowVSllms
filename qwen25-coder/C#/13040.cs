using System;\nusing System.Collections.Generic;\nusing System.DirectoryServices;\nusing System.Diagnostics;\n\nprivate static Collection<string> GetDirectReportsIterative(string ldapBase, string userDN, out long elapsedTime)\n{\n    Stack<string> userStack = new Stack<string>();\n    Collection<string> result = new Collection<string>();\n    Stopwatch sw = new Stopwatch();\n    sw.Start();\n\n    userStack.Push(userDN);\n\n    try\n    {\n        using (DirectoryEntry directoryEntry = new DirectoryEntry(ldapBase))\n        {\n            using (DirectorySearcher ds = new DirectorySearcher(directoryEntry))\n            {\n                ds.SearchScope = SearchScope.Subtree;\n                ds.PropertiesToLoad.Add("userPrincipalName");\n                ds.PropertiesToLoad.Add("distinguishedName");\n                ds.PageSize = 10;\n                ds.ServerPageTimeLimit = TimeSpan.FromSeconds(2);\n\n                while (userStack.Count > 0)\n                {\n                    string currentDN = userStack.Pop();\n                    ds.Filter = $"(&(objectCategory=user)(manager={currentDN}))";\n\n                    using (SearchResultCollection src = ds.FindAll())\n                    {\n                        foreach (SearchResult sr in src)\n                        {\n                            if (sr.Properties["userPrincipalName"].Count > 0)\n                                result.Add((string)sr.Properties["userPrincipalName"][0]);\n                            \n                            if (sr.Properties["distinguishedName"].Count > 0)\n                                userStack.Push((string)sr.Properties["distinguishedName"][0]);\n                        }\n                    }\n                }\n            }\n        }\n    }\n    catch (Exception ex)\n    {\n        Console.WriteLine($"An error occurred: {ex.Message}");\n    }\n\n    sw.Stop();\n    elapsedTime = sw.ElapsedMilliseconds;\n    return result;\n}