HtmlDocument htmldoc = new HtmlDocument();\nhtmldoc.LoadHtml(content);\nHtmlNodeCollection linkNodes = htmldoc.DocumentNode.SelectNodes("//a[@href]");\n\nforeach (HtmlNode linkNode in linkNodes)\n{\n    string linkTitle = linkNode.GetAttributeValue("title", string.Empty);\n    if (linkTitle == string.Empty)\n    {\n        // Use a relative XPath to find img child node\n        HtmlNode imageNode = linkNode.SelectSingleNode(".//img[@alt]");     \n        if (imageNode != null)\n        {\n            string altAttribute = imageNode.GetAttributeValue("alt", string.Empty);\n            // Do something with the alt attribute\n        }\n    }\n}