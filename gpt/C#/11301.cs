using System;\nusing System.IO;\nusing System.Text;\nusing System.Web.UI;\nusing System.Xml;\n\npublic partial class DisplayXml : Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        // Load your XML into an XmlDocument\n        XmlDocument xmlDoc = new XmlDocument();\n        xmlDoc.LoadXml("<root><child>value</child></root>"); // Replace with your XML\n\n        // Format the XML with indentation\n        string formattedXml = FormatXml(xmlDoc);\n\n        // Display the formatted XML in a Literal control\n        xmlLiteral.Text = Server.HtmlEncode(formattedXml);\n    }\n\n    private string FormatXml(XmlDocument xmlDoc)\n    {\n        StringBuilder sb = new StringBuilder();\n        using (StringWriter sw = new StringWriter(sb))\n        {\n            using (XmlTextWriter xtw = new XmlTextWriter(sw))\n            {\n                xtw.Formatting = Formatting.Indented;\n                xmlDoc.WriteTo(xtw);\n            }\n        }\n        return sb.ToString();\n    }\n}