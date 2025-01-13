using System;\nusing System.Collections.Generic;\n\nclass Program\n{\n    static void Main()\n    {\n        string input = "your \"quoted argument\" here";\n        string[] args = SplitArgs(input);\n        \n        foreach (var arg in args)\n        {\n            Console.WriteLine(arg);\n        }\n    }\n\n    static string[] SplitArgs(string commandLine)\n    {\n        var result = new List<string>();\n        bool inQuotes = false;\n        bool escaped = false;\n        int start = 0;\n\n        for (int i = 0; i < commandLine.Length; ++i)\n        {\n            char c = commandLine[i];\n            \n            if (c == '\\' && i + 1 < commandLine.Length && (commandLine[i + 1] == '\"' || commandLine[i + 1] == '\\'))\n            {\n                escaped = true;\n                continue;\n            }\n\n            if (!escaped && c == '\"')\n            {\n                inQuotes = !inQuotes;\n            }\n            else if ((c == ' ' || i + 1 >= commandLine.Length) && !inQuotes)\n            {\n                result.Add(commandLine.Substring(start, i - start).Trim('"').Replace("\\\"", "\""));\n                start = i + 1;\n            }\n            \n            escaped = false;\n        }\n\n        return result.ToArray();\n    }\n}