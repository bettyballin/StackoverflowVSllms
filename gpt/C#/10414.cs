using System;\nusing System.Text.RegularExpressions;\nusing System.Web;\n\nclass HtmlSanitizer\n{\n    /// <summary>\n    /// A regex that matches things that look like a HTML tag after HtmlEncoding.\n    /// </summary>\n    private static Regex _tags = new Regex("&#60;(?!&#62;).+?(&#62;|$)", RegexOptions.Singleline | RegexOptions.ExplicitCapture | RegexOptions.Compiled);\n\n    /// <summary>\n    /// A regex that will match tags on the whitelist, so we can run them through HttpUtility.HtmlDecode.\n    /// </summary>\n    private static Regex _whitelist = new Regex(@"^&#60;/?(a|b(lockquote)?|code|em|h(1|2|3)|i|li|ol|p(re)?|s(ub|up|trong|trike)?|ul)&#62;$|^&#60;(b|h)r\s?/?&#62;$|^&#60;a(?!&#62;).+?&#62;$|^&#60;img(?!&#62;).+?/?&#62;$", RegexOptions.Singleline | RegexOptions.IgnorePatternWhitespace | RegexOptions.ExplicitCapture | RegexOptions.Compiled);\n\n    /// <summary>\n    /// HtmlDecode any potentially safe HTML tags from the provided HtmlEncoded HTML input using a whitelist based approach, leaving the dangerous tags Encoded HTML tags.\n    /// </summary>\n    public static string Sanitize(string html)\n    {\n        string tagname = "";\n        Match tag;\n        MatchCollection tags = _tags.Matches(html);\n        string safeHtml = "";\n\n        // iterate through all HTML tags in the input\n        for (int i = tags.Count - 1; i > -1; i--)\n        {\n            tag = tags[i];\n            tagname = tag.Value.ToLowerInvariant();\n\n            if (_whitelist.IsMatch(tagname))\n            {\n                // If we find a tag on the whitelist, run it through HtmlDecode, and re-insert it into the text\n                safeHtml = HttpUtility.HtmlDecode(tag.Value);\n                html = html.Remove(tag.Index, tag.Length);\n                html = html.Insert(tag.Index, safeHtml);\n            }\n        }\n\n        return html;\n    }\n}\n\n// Usage example\nclass Program\n{\n    static void Main()\n    {\n        string inputHtml = "alert('XSS')bold should work";\n        string encodedHtml = AntiXss.HtmlEncode(inputHtml); // Assuming AntiXss.HtmlEncode is used\n        string sanitizedHtml = HtmlSanitizer.Sanitize(encodedHtml);\n        Console.WriteLine(sanitizedHtml);\n    }\n}