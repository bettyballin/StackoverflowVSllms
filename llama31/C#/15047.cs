using System.Windows.Documents;\n\nstring html = "<p>Hello World!</p>";\nstring xaml = HtmlToXamlConverter.ConvertHtmlToXaml(html);