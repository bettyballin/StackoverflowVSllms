using System;\nusing System.IO;\nusing WkHtmlToPdf;\n\nclass HtmlToPdf\n{\n    static void Main(string[] args)\n    {\n        string html = "<html>...</html>";\n        string css = "body { font-size: 14px; }";\n\n        var wkHtmlToPdf = new WkHtmlToPdf();\n        wkHtmlToPdf.SetPageSize(WkHtmlToPdf.PageSize.A4);\n        wkHtmlToPdf.SetHtml(html);\n        wkHtmlToPdf.SetCss(css);\n        wkHtmlToPdf.SetOutputFile("output.pdf");\n\n        wkHtmlToPdf.Convert();\n    }\n}