using System;\nusing System.Linq;\nusing System.Xml.Linq;\n\nclass Program\n{\n    static void Main()\n    {\n        string xmlContent = @"\n<root>\n    <item>\n        <title><p>some title</p></title>\n    </item>\n    <!-- More items can go here -->\n</root>";\n\n        XDocument doc = XDocument.Parse(xmlContent);\n\n        var titles = doc.Descendants("title")\n                         .Select(title => title.ToString(SaveOptions.DisableFormatting))\n                         .ToList();\n\n        foreach (var title in titles)\n        {\n            // Here you would add the title to your repeater\n            Console.WriteLine(title);\n        }\n    }\n}