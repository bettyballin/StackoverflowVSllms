using HtmlAgilityPack;\nusing System;\nusing System.Collections.Generic;\n\nclass Program\n{\n    static void Main()\n    {\n        var url = "https://example.com"; // Replace with your target URL\n        var web = new HtmlWeb();\n        var doc = web.Load(url);\n\n        // Use XPath to select all tables\n        var tables = doc.DocumentNode.SelectNodes("//table");\n\n        if (tables != null)\n        {\n            foreach (var table in tables)\n            {\n                Console.WriteLine("Table found!");\n                var rows = table.SelectNodes(".//tr");\n                foreach (var row in rows)\n                {\n                    var cells = row.SelectNodes(".//th|.//td");\n                    foreach (var cell in cells)\n                    {\n                        Console.Write(cell.InnerText.Trim() + " ");\n                    }\n                    Console.WriteLine();\n                }\n                Console.WriteLine();\n            }\n        }\n        else\n        {\n            Console.WriteLine("No tables found.");\n        }\n    }\n}