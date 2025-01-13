private static string ConvertHtmlEntities(string text)\n{\n    text = text.Replace("&alpha;", "&#945;");\n    text = text.Replace("&nbsp;", "&#160;");\n    text = text.Replace("&ndash;", "&#8211;");\n    text = text.Replace("&mdash;", "&#8212;");\n    // Add more replacements as needed\n    return text;\n}\n\nXmlDocument xmldoc = new XmlDocument();\nstring text = "Hello, I am text &alpha; &nbsp; &ndash; &mdash;";\ntext = ConvertHtmlEntities(text);\nxmldoc.InnerXml = "<p>" + text + "</p>";