using System;\nusing System.Collections.Generic;\n\npublic class Program {\n    public static void Main() {\n        List<string> ids = new List<string>();\n        ids.Add("1");\n        ids.Add("2");\n        ids.Add("3");\n\n        string commaDelimited = string.Join(",", ids);\n        Console.WriteLine(commaDelimited);\n    }\n}