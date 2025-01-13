using HtmlAgilityPack;\nusing System;\nusing System.Text;\n\nclass Program\n{\n    static void Main()\n    {\n        // Load the HTML document with the correct encoding\n        var web = new HtmlWeb();\n        web.OverrideEncoding = Encoding.GetEncoding("ISO-8859-1"); // Latin1 Encoding\n        var doc = web.Load("path_to_your_latin1_encoded_html_file.html");\n\n        // Define the XPath query\n        string xpathQuery = @"//h2[text()='Företag']/../div//span[text()='Resultat:']/../div";\n\n        // Execute the XPath query\n        var nodes = doc.DocumentNode.SelectNodes(xpathQuery);\n\n        // Process the nodes as needed\n        if (nodes != null)\n        {\n            foreach (var node in nodes)\n            {\n                Console.WriteLine(node.InnerHtml);\n            }\n        }\n        else\n        {\n            Console.WriteLine("No nodes found matching the XPath query.");\n        }\n    }\n}