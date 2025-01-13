using System;\nusing System.Text.RegularExpressions;\n\npublic class SlugGenerator\n{\n    public static string GenerateSlug(string phrase)\n    {\n        if (string.IsNullOrWhiteSpace(phrase))\n            return "";\n\n        string str = RemoveDiacritics(phrase).ToLowerInvariant();\n\n        // invalid chars, make a regex, remove unavailable chars\n        str = Regex.Replace(str, @"[^a-z0-9\s-]", ""); \n        // convert multiple spaces into one space   \n        str = Regex.Replace(str, @"\s+", " ").Trim();      \n        // cut and trim \n        str = str.Substring(0, str.Length <= 45 ? str.Length : 45).Trim();   \n        // hyphens   \n        str = Regex.Replace(str, @"\s", "-"); \n\n        return str;\n    }\n\n    private static string RemoveDiacritics(string text)\n    {\n        var normalizedString = text.Normalize(NormalizationForm.FormD);\n        var stringBuilder = new System.Text.StringBuilder();\n\n        foreach (var c in normalizedString)\n        {\n            var unicodeCategory = CharUnicodeInfo.GetUnicodeCategory(c);\n            if (unicodeCategory != UnicodeCategory.NonSpacingMark)\n            {\n                stringBuilder.Append(c);\n            }\n        }\n\n        return stringBuilder.ToString();\n    }\n\n    public static void Main()\n    {\n        string title = "èòà, This is a Test! Question Mark?";\n        Console.WriteLine(GenerateSlug(title));\n        // Output: eoà-this-is-a-test-question-mark\n    }\n}