using System;\nusing System.Text.RegularExpressions;\n\nclass Program\n{\n    static void Main()\n    {\n        string input = "{Token1}asdasasd{Token2}asd asdacscadase dfb db {Token3}";\n        string pattern = @"\{(.+?)\}";\n\n        Regex regex = new Regex(pattern);\n        MatchCollection matches = regex.Matches(input);\n\n        foreach (Match match in matches)\n        {\n            Console.WriteLine(match.Groups[1].Value);\n        }\n    }\n}