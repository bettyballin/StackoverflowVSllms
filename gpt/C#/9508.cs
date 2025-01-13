using System;\nusing System.Collections.Generic;\n\nclass Program\n{\n    static void Main()\n    {\n        List<List<string>> lists = new List<List<string>>\n        {\n            new List<string> { "A1", "A2", "A3" },\n            new List<string> { "B1", "B2" },\n            new List<string> { "C1", "C2", "C3", "C4", "C5" }\n        };\n\n        List<string> combinedList = CombineListsRoundRobin(lists);\n\n        foreach (string item in combinedList)\n        {\n            Console.WriteLine(item);\n        }\n    }\n\n    static List<string> CombineListsRoundRobin(List<List<string>> lists)\n    {\n        List<string> result = new List<string>();\n        int totalItems = 0;\n\n        // Calculate the total number of items\n        foreach (var list in lists)\n        {\n            totalItems += list.Count;\n        }\n\n        // Use round-robin to combine items\n        int index = 0;\n        while (result.Count < totalItems)\n        {\n            foreach (var list in lists)\n            {\n                if (index < list.Count)\n                {\n                    result.Add(list[index]);\n                }\n            }\n            index++;\n        }\n\n        return result;\n    }\n}