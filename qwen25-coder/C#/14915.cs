XmlDocument xmldoc = new XmlDocument();\nstring text = "Hello, I am text α \u00A0 – —"; // Alpha and non-breaking space are Unicode\ntext = text.Replace("–", "&#8211;").Replace("—", "&#8212;");\nxmldoc.InnerXml = "<p>" + SecurityElement.Escape(text) + "</p>";