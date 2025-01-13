using System;\nusing System.Collections.Generic;\nusing System.Linq;\n\npublic class DataEntry\n{\n    public string Username { get; set; }\n    public int DateKey { get; set; }\n    public int LoginTimeKey { get; set; }\n    public int Amount { get; set; }\n\n    // Constructor for easy initialization\n    public DataEntry(string username, int dateKey, int loginTimeKey, int amount)\n    {\n        Username = username;\n        DateKey = dateKey;\n        LoginTimeKey = loginTimeKey;\n        Amount = amount;\n    }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        var dataEntries = new List<DataEntry>\n        {\n            new DataEntry("A", 1, 1, 50),\n            new DataEntry("A", 1, 2, 50),\n            new DataEntry("A", 2, 1, 20),\n            new DataEntry("A", 2, 2, 60),\n            new DataEntry("B", 1, 1, 35),\n            new DataEntry("B", 1, 2, 35),\n            new DataEntry("C", 1, 1, 80),\n            new DataEntry("D", 1, 1, 12),\n            new DataEntry("D", 1, 2, 12),\n            new DataEntry("D", 1, 3, 15),\n            new DataEntry("D", 2, 1, 12)\n        };\n\n        // Process the data to set non-last amounts to 0\n        var processedEntries = dataEntries\n            .GroupBy(entry => new { entry.Username, entry.DateKey })\n            .SelectMany(group =>\n                group.OrderBy(entry => entry.LoginTimeKey).Select((entry, index) => \n                    new DataEntry(\n                        entry.Username,\n                        entry.DateKey,\n                        entry.LoginTimeKey,\n                        index == group.Count() - 1 ? entry.Amount : 0\n                    )\n                ))\n            .ToList();\n\n        // Print out the processed entries\n        foreach (var entry in processedEntries)\n        {\n            Console.WriteLine($"{entry.Username}  {entry.DateKey}  {entry.LoginTimeKey}  {entry.Amount}");\n        }\n    }\n}