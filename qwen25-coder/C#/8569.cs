using System;\nusing System.Text;\n\npublic class FastSearch\n{\n    public static int[] MakeBadMatchTable(string pattern)\n    {\n        var table = new int[256];\n        for (int i = 0; i < table.Length; i++)\n            table[i] = pattern.Length;\n        for (int i = 0; i < pattern.Length - 1; i++)\n            table[pattern[i]] = pattern.Length - i - 1;\n        return table;\n    }\n\n    public static bool BoyerMooreSearch(string text, string pattern)\n    {\n        if (string.IsNullOrEmpty(text) || string.IsNullOrEmpty(pattern))\n            return false;\n\n        var badMatchTable = MakeBadMatchTable(pattern);\n        int s = 0;\n        while (s <= text.Length - pattern.Length)\n        {\n            int j = pattern.Length - 1;\n            while (j >= 0 && pattern[j] == text[s + j])\n                j--;\n            if (j < 0)\n                return true; // Pattern found\n            else\n                s += Math.Max(1, badMatchTable[text[s + j]] - (pattern.Length - j - 1));\n        }\n        return false;\n    }\n\n    public static void Main()\n    {\n        string text = "Example text for searching";\n        string pattern = "searching";\n        \n        if (BoyerMooreSearch(text, pattern))\n            Console.WriteLine("Pattern found!");\n        else\n            Console.WriteLine("Pattern not found.");\n    }\n}