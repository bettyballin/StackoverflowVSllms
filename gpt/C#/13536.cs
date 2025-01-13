using System;\nusing System.Text.RegularExpressions;\n\npublic class WikiMarkupConverter\n{\n    public static string ConvertToHtml(string wikiText)\n    {\n        if (string.IsNullOrEmpty(wikiText))\n        {\n            return string.Empty;\n        }\n\n        // Convert ==Heading== to <h2>Heading</h2>\n        string html = Regex.Replace(wikiText, @"==(.+?)==", "<h2>$1</h2>");\n\n        // Convert --bold-- to <b>bold</b>\n        html = Regex.Replace(html, @"--(.+?)--", "<b>$1</b>");\n\n        // Add any additional conversions here as needed\n\n        return html;\n    }\n\n    public static void Main(string[] args)\n    {\n        string wikiText = "==Heading==\nSome text with --bold-- word.";\n        string html = ConvertToHtml(wikiText);\n\n        Console.WriteLine(html);\n    }\n}