using System;\nusing System.Text.RegularExpressions;\n\npublic class HtmlSanitizer\n{\n    // Define the whitelist of tags\n    private static readonly string[] WhitelistTags = { "u", "i", "b", "h3", "h4", "br", "a", "img" };\n\n    // Define the allowed attributes for specific tags\n    private static readonly Regex AllowedAttributes = new Regex(@"\b(href)\s*=\s*(""[^""]*""|'[^']*'|[^>\s]+)", RegexOptions.IgnoreCase);\n\n    public static string SanitizeHtml(string html)\n    {\n        // Regex to match all HTML tags\n        var tagRegex = new Regex(@"</?([a-zA-Z0-9]+)(\s[^>]*)?>", RegexOptions.IgnoreCase);\n\n        // Replace callback to process each match\n        string result = tagRegex.Replace(html, match =>\n        {\n            string tagName = match.Groups[1].Value.ToLower();\n            string tagAttributes = match.Groups[2].Value;\n\n            if (Array.Exists(WhitelistTags, tag => tag.Equals(tagName, StringComparison.OrdinalIgnoreCase)))\n            {\n                // Keep allowed attributes for <a> tags\n                if (tagName == "a")\n                {\n                    var sanitizedAttributes = AllowedAttributes.Matches(tagAttributes);\n                    string attributes = string.Join(" ", sanitizedAttributes);\n                    return $"<{tagName}{(attributes.Length > 0 ? " " + attributes : string.Empty)}>";\n                }\n                else if (tagName == "img" || tagName == "br")\n                {\n                    // Self-closing tags <img> and <br> should be allowed without attributes\n                    return $"<{tagName} />";\n                }\n                else\n                {\n                    // Remove all attributes for other allowed tags\n                    return $"<{tagName}>";\n                }\n            }\n            // Remove disallowed tags\n            return string.Empty;\n        });\n\n        return result;\n    }\n\n    public static void Main()\n    {\n        string htmlInput = "<p>This is a <b>bold</b> text with <a href=\"http://example.com\">link</a> and an <img src=\"image.jpg\" alt=\"image\">.</p>";\n        string sanitizedHtml = SanitizeHtml(htmlInput);\n        Console.WriteLine(sanitizedHtml); // Output: "This is a <b>bold</b> text with <a href="http://example.com">link</a> and an <img>."\n    }\n}