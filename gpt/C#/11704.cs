using System;\nusing System.Text.RegularExpressions;\n\nclass Program\n{\n    static void Main()\n    {\n        string input = "value_name v1,v2,v3,v4";\n        string pattern = @"^value_name\s+([^,]+(?:,[^,]+)*)$";\n        \n        Match match = Regex.Match(input, pattern);\n        \n        if (match.Success)\n        {\n            string values = match.Groups[1].Value;\n            string[] splitValues = values.Split(',');\n\n            foreach (string value in splitValues)\n            {\n                Console.WriteLine(value);\n            }\n        }\n        else\n        {\n            Console.WriteLine("No match found.");\n        }\n    }\n}