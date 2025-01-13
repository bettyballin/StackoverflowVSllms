using System;\nusing System.Text.RegularExpressions;\n\nclass Program\n{\n    static void Main()\n    {\n        string input = "<span class='Txt9Gray'>(T)KOs ( </span> 66.67 <span class='Txt9Gray'>%) </span> <br /> 1 <span class='Txt9Gray'>Decisions ( </span> 33.33 <span class='Txt9Gray'>%) </span> <br />";\n        string pattern = @"(?<=\s|^)(\d+)\s*<span\s+class=['"][^'"]*'\b>Decisions\b</span>";\n        Match match = Regex.Match(input, pattern);\n        \n        if (match.Success)\n        {\n            Console.WriteLine("Found number: " + match.Groups[1].Value);\n        }\n    }\n}