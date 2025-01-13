private string GrabImage(string htmlContent)\n{\n    HtmlAgilityPack.HtmlDocument htmlDoc = new HtmlAgilityPack.HtmlDocument();\n    htmlDoc.LoadHtml(htmlContent);\n    \n    // Select the first <img> node\n    HtmlAgilityPack.HtmlNode imageNode = htmlDoc.DocumentNode.SelectSingleNode("//img");\n    \n    if (imageNode != null)\n    {\n        // Return the outer HTML of the image node\n        return imageNode.OuterHtml;          \n    }\n    \n    // Return an empty string instead of a single space if no image is found\n    return string.Empty;\n}