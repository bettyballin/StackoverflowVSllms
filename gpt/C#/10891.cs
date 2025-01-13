using System;\n\npublic class HtmlToPlainText\n{\n    public static void Main()\n    {\n        string htmlContent = @"The victory halted Spain&rsquo;s 35-game unbeaten streak, handing the Spanish their first defeat since November 2006. The Americans now advance to the final Sunday to face the winner of Thursday&rsquo;s semifinal between South Africa and Brazil, the five-time World Cup winner. Brazil defeated the Americans, 3-0, in their earlier meeting in this tournament.<br>\n<br>\nIn the final, though, the United States will be without midfielder Michael Bradley, who received a red card for a harsh tackle in the 87th minute, the third such ejection for the Americans in this tournament. It was the only careless blemish on an otherwise nearly perfect evening.";\n\n        string plainText = ConvertHtmlToPlainText(htmlContent);\n        Console.WriteLine(plainText);\n    }\n\n    public static string ConvertHtmlToPlainText(string html)\n    {\n        if (string.IsNullOrEmpty(html))\n            return string.Empty;\n\n        // Replace <br> tags with new line characters\n        string plainText = html.Replace("<br>", Environment.NewLine)\n                               .Replace("<br/>", Environment.NewLine)\n                               .Replace("<br />", Environment.NewLine)\n                               .Trim();\n\n        // Optionally, decode HTML entities (e.g., &rsquo;)\n        plainText = System.Net.WebUtility.HtmlDecode(plainText);\n\n        return plainText;\n    }\n}