class Program\n{\n    static void Main(string[] args)\n    {\n        string html = \n@"<html>\n<head>\n  <meta http-equiv=""Content-Type"" content=""text/html; charset=utf-8"" />\n</head>\n<body>\n  <p style=""color: red;"">Hello World</p>\n</body>\n</html>";\n\n        Document document = new Document(PageSize.A4);\n        using (Stream output = new FileStream("out.pdf", FileMode.Create, FileAccess.Write, FileShare.None))\n        using (StringReader htmlReader = new StringReader(html))\n        using (XmlTextReader reader = new XmlTextReader(htmlReader))\n        {\n            PdfWriter.GetInstance(document, output);\n            HtmlParser.Parse(document, reader);\n        }\n\n    }\n}