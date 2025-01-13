using System;\nusing System.Text.RegularExpressions;\n\nclass Program\n{\n    static void Main()\n    {\n        string inputHtml = "<p>This is a <b>bold</b> text with a <a href='http://example.com'>link</a>.<img src='image.png'></p>";\n        string cleanHtml = SanitizeHtml(inputHtml);\n        Console.WriteLine(cleanHtml);\n    }\n\n    static string SanitizeHtml(string html)\n    {\n        // Define the allowed tags\n        string acceptableTags = "i|b|h3|h4|br|a|img";\n        \n        // Regex pattern to match unwanted tags and sanitize attributes\n        string regexPattern = $@"</?(?!({acceptableTags})\b)[a-zA-Z0-9]+\b.*?>|<(({acceptableTags})\b)(?:[^>]*?((href)=""[^""]*"")?)?.*?>/?>";\n        \n        // Replace unwanted tags with an empty string and clean attributes\n        html = Regex.Replace(html, regexPattern, match =>\n        {\n            string tagMatch = match.Groups[2].Value;\n            if (tagMatch != "")\n            {\n                // If it's an allowed tag but may have undesirable attributes, keep only the tag and its allowed attribute(s)\n                return $"<{match.Groups[3].Value} {match.Groups[5].Value ?? ""}/>";\n            }\n            // Remove unwanted tags\n            return "";\n        }, RegexOptions.IgnoreCase | RegexOptions.Compiled);\n\n        return html;\n    }\n}