public class CustomPage : System.Web.UI.Page\n{\n    protected override void Render(HtmlTextWriter writer)\n    {\n        var sw = new StringWriter();\n        var htmlWriter = new HtmlTextWriter(sw);\n        base.Render(htmlWriter);\n        var html = sw.ToString();\n\n        // Process the HTML output here\n        // For example, you can use regular expressions to modify internal links\n        html = Regex.Replace(html, @"href=""(?<url>[\w\./]+)""", match => \n        {\n            var url = match.Groups["url"].Value;\n            // Modify the URL with your session information\n            return $"href=\"{url}?session={GetSessionInfo()}\"";\n        });\n\n        writer.Write(html);\n    }\n\n    private string GetSessionInfo()\n    {\n        // Implement your session information retrieval logic here\n        return "some_session_info";\n    }\n}