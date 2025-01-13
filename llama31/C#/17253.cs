using System;\nusing System.Collections.Generic;\nusing System.IO;\nusing System.Linq;\n\npublic class RegCleaner\n{\n    public static void CleanRegFile(string inputFile, string outputFile)\n    {\n        // Read the input file\n        string[] lines = File.ReadAllLines(inputFile);\n\n        // Parse the lines into a dictionary\n        var regEntries = new Dictionary<string, string>();\n        string currentHive = null;\n        foreach (string line in lines)\n        {\n            if (line.StartsWith("["))\n            {\n                currentHive = line.Trim('[', ']');\n            }\n            else\n            {\n                string[] parts = line.Split('=');\n                if (parts.Length == 2)\n                {\n                    string key = parts[0].Trim('"');\n                    string value = parts[1].Trim('"');\n                    regEntries[$"{currentHive},{key}"] = value;\n                }\n            }\n        }\n\n        // Sort the entries by hive\n        var sortedEntries = regEntries.OrderBy(e => e.Key.Split(',')[0]);\n\n        // Write the output file\n        using (StreamWriter writer = new StreamWriter(outputFile))\n        {\n            string previousHive = null;\n            foreach (var entry in sortedEntries)\n            {\n                string[] parts = entry.Key.Split(',');\n                string hive = parts[0];\n                string key = parts[1];\n                string value = entry.Value;\n\n                if (hive != previousHive)\n                {\n                    writer.WriteLine($"[{hive}]");\n                    previousHive = hive;\n                }\n\n                writer.WriteLine($"\"{key}\"=\"{value}\"");\n            }\n        }\n    }\n}