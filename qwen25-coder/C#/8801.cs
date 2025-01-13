using System;\nusing System.Linq;\nusing System.Text.RegularExpressions;\nusing System.Xml.XPath;\n\nclass Program\n{\n    static void Main()\n    {\n        string xml = "<root><div id='foo123'/><div id='bar456'/></root>";\n        XPathDocument doc = new XPathDocument(new System.IO.StringReader(xml));\n        XPathNavigator nav = doc.CreateNavigator();\n\n        // Select all divs with ids starting 'foo'\n        XPathNodeIterator nodes = nav.Select("//div[starts-with(@id, 'foo')]");\n\n        // Regex pattern to match ids like 'foo123'\n        Regex regex = new Regex(@"^foo\d+$", RegexOptions.Compiled);\n\n        // Iterate over nodes and check with regex\n        while (nodes.MoveNext())\n        {\n            if (regex.IsMatch(nodes.Current.GetAttribute("id", "")))\n            {\n                Console.WriteLine("Found node: " + nodes.Current.OuterXml);\n            }\n        }\n    }\n}