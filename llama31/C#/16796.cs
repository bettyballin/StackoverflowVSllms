using System.Text.RegularExpressions;\nusing HtmlAgilityPack;\n\npublic static string SanitizeHtml(string html)\n{\n    var whitelist = new[] { "u", "i", "b", "h3", "h4", "br", "a", "img" };\n    var doc = new HtmlDocument();\n    doc.LoadHtml(html);\n\n    foreach (var node in doc.DocumentNode.Descendants())\n    {\n        if (!whitelist.Contains(node.Name))\n        {\n            node.ParentNode.RemoveChild(node, true);\n        }\n        else\n        {\n            node.Attributes.Where(a => a.Name != "href" || node.Name != "a").ToList().ForEach(a => a.Remove());\n        }\n    }\n\n    return doc.DocumentNode.OuterHtml;\n}