using HtmlAgilityPack;\nusing System;\nusing System.Linq;\n\npublic class Program\n{\n    public static void Main()\n    {\n        var html = @"\n        <tr>\n            <td title=""Associated temperature in (ºC)"" class=""TABLEDATACELL"" nowrap=""nowrap"" align=""Left"" colspan=""1"" rowspan=""1"">Max Temperature (ºC)</td>\n            <td class=""TABLEDATACELLNOTT"" nowrap=""nowrap"" align=""Center"" colspan=""1"" rowspan=""1"">6</td>\n            <td class=""TABLEDATACELLNOTT"" nowrap=""nowrap"" align=""Center"" colspan=""1"" rowspan=""1""> 13:41:30</td>\n        </tr>";\n\n        var doc = new HtmlDocument();\n        doc.LoadHtml(html);\n\n        var row = doc.DocumentNode.SelectSingleNode("//tr");\n\n        if (row != null)\n        {\n            var cells = row.SelectNodes("td");\n\n            if (cells != null && cells.Count >= 3)\n            {\n                var maxTemperature = cells[0].InnerText.Trim();\n                var value = cells[1].InnerText.Trim();\n                var time = cells[2].InnerText.Trim();\n\n                Console.WriteLine($"Max Temperature: {maxTemperature}");\n                Console.WriteLine($"Value: {value}");\n                Console.WriteLine($"Time: {time}");\n            }\n        }\n    }\n}