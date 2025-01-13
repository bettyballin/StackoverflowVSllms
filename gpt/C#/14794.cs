using HtmlAgilityPack;\nusing System;\n\nclass Program\n{\n    static void Main()\n    {\n        var html = "<html><body><p>Hello, World!</p></body></html>";\n        var htmlDoc = new HtmlDocument();\n        htmlDoc.LoadHtml(html);\n\n        // Read HTML\n        var paragraph = htmlDoc.DocumentNode.SelectSingleNode("//p");\n        Console.WriteLine(paragraph.InnerText); // Output: Hello, World!\n\n        // Edit HTML\n        paragraph.InnerHtml = "Hello, .NET!";\n        Console.WriteLine(htmlDoc.DocumentNode.OuterHtml);\n        // Output: <html><body><p>Hello, .NET!</p></body></html>\n    }\n}