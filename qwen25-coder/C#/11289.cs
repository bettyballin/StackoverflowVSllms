using System;\nusing System.Xml;\nusing System.Text.RegularExpressions;\n\nclass Program\n{\n    static void Main()\n    {\n        string xml = @"<root><item>test123</item><item>sample</item><item>example456</item></root>";\n        XmlDocument doc = new XmlDocument();\n        doc.LoadXml(xml);\n        \n        // Define your pattern here\n        string pattern = @"\d+";\n        Regex regex = new Regex(pattern);\n\n        foreach (XmlNode node in doc.SelectNodes("//item"))\n        {\n            if (regex.IsMatch(node.InnerText))\n            {\n                Console.WriteLine("Node with matching content: " + node.InnerText);\n            }\n        }\n    }\n}