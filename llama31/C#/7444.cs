public class XPathExtension : MarkupExtension\n{\n    public string XPath { get; set; }\n\n    public override object ProvideValue(IServiceProvider serviceProvider)\n    {\n        var xmlElement = serviceProvider.GetService(typeof(XmlElement)) as XmlElement;\n        if (xmlElement != null)\n        {\n            var navigator = xmlElement.CreateNavigator();\n            var result = navigator.SelectSingleNode(XPath);\n            if (result != null)\n            {\n                return result.Value;\n            }\n        }\n        return null;\n    }\n}