using HtmlAgilityPack;\n\nclass Program\n{\n    static void Main()\n    {\n        var doc = new HtmlDocument();\n        doc.Load("http://example.com");\n\n        // Select nodes using XPath\n        foreach (var node in doc.DocumentNode.SelectNodes("//a[@href]"))\n        {\n            HtmlAttribute attr = node.Attributes["href"];\n            System.Console.WriteLine(attr.Value);\n        }\n    }\n}