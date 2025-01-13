using HtmlAgilityPack;\n\nvar htmlDoc = new HtmlDocument();\nhtmlDoc.LoadHtml(html);\n\nvar titleNode = htmlDoc.DocumentNode.SelectSingleNode("//title");\nvar articleNode = htmlDoc.DocumentNode.SelectSingleNode("//div[@class='article']");\n\nif (titleNode != null && articleNode != null)\n{\n    string title = titleNode.InnerText;\n    string text = articleNode.InnerText;\n    // Process the extracted title and text\n}