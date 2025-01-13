using System;\nusing System.Collections.Generic;\nusing System.Linq;\n\npublic class StringSimilarity\n{\n    public static double CosineSimilarity(string s1, string s2)\n    {\n        var vec1 = GetTermFrequency(s1);\n        var vec2 = GetTermFrequency(s2);\n\n        double dotProduct = vec1.Zip(vec2, (a, b) => a * b).Sum();\n        double magnitude1 = Math.Sqrt(vec1.Sum(x => x * x));\n        double magnitude2 = Math.Sqrt(vec2.Sum(x => x * x));\n\n        if (magnitude1 == 0 || magnitude2 == 0)\n            return 0;\n\n        return dotProduct / (magnitude1 * magnitude2);\n    }\n\n    private static List<int> GetTermFrequency(string str)\n    {\n        var terms = str.Split(new[] { ' ', '_', '.', '-' }, StringSplitOptions.RemoveEmptyEntries);\n        var termFreq = new Dictionary<string, int>();\n\n        foreach (var term in terms)\n        {\n            if (termFreq.ContainsKey(term))\n                termFreq[term]++;\n            else\n                termFreq[term] = 1;\n        }\n\n        return termFreq.Values.ToList();\n    }\n\n    public static void Main()\n    {\n        var list1 = new List<string> { "MAIZE_SLIP_QUANTITY_3_9.1.aif" };\n        var list2 = new List<string>\n        {\n            "TUTORIAL_FAILURE_CLINCH_4.1.aif",\n            "MAIZE_SLIP_QUANTITY_3_5.1.aif",\n            "MAIZE_SLIP_QUANTITY_3_9.2.aif",\n            "TUTORIAL_FAILURE_CLINCH_5.1.aif",\n            "TUTORIAL_FAILURE_CLINCH_6.1.aif",\n            "TUTORIAL_FAILURE_CLINCH_7.1.aif",\n            "TUTORIAL_FAILURE_CLINCH_8.1.aif",\n            "TUTORIAL_FAILURE_CLINCH_9.1.aif",\n            "TUTORIAL_FAILURE_PUSH_4.1.aif"\n        };\n\n        foreach (var file1 in list1)\n        {\n            double maxSimilarity = 0;\n            string bestMatch = null;\n\n            foreach (var file2 in list2)\n            {\n                double similarity = CosineSimilarity(file1, file2);\n                if (similarity > maxSimilarity)\n                {\n                    maxSimilarity = similarity;\n                    bestMatch = file2;\n                }\n            }\n\n            Console.WriteLine($"Best match for '{file1}' is '{bestMatch}' with similarity {maxSimilarity}");\n        }\n    }\n}