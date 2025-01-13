using System.IO;\nusing System.Web.UI;\n\npublic class CustomHtmlTextWriter : HtmlTextWriter\n{\n    public CustomHtmlTextWriter(TextWriter writer) : base(writer) { }\n}\n\npublic class Program\n{\n    public static void Main()\n    {\n        using (var writer = new StringWriter())\n        {\n            var htmlWriter = new CustomHtmlTextWriter(writer);\n            writer.NewLine = "\r\n";\n            htmlWriter.IndentChar = ' '; // Use space instead of tab\n            htmlWriter.IndentSize = 4; // Set the number of spaces for each indent\n\n            htmlWriter.WriteFullBeginTag("html");\n            htmlWriter.WriteLine();\n            htmlWriter.WriteFullBeginTag("body");\n            htmlWriter.WriteLine();\n            htmlWriter.Indent++;\n            htmlWriter.WriteFullBeginTag("div");\n            htmlWriter.WriteLine();\n            htmlWriter.Indent++;\n            htmlWriter.WriteFullBeginTag("p");\n            htmlWriter.Write("foo");\n            htmlWriter.WriteEndTag("p");\n            htmlWriter.Indent--;\n            htmlWriter.WriteLine();\n            htmlWriter.WriteEndTag("div");\n            htmlWriter.Indent--;\n            htmlWriter.WriteLine();\n            htmlWriter.WriteEndTag("body");\n            htmlWriter.WriteLine();\n            htmlWriter.WriteEndTag("html");\n\n            var html = writer.ToString();\n            // Use the generated HTML\n        }\n    }\n}