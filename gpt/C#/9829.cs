using CsQuery;\n\n   var dom = CQ.CreateFromUrl("http://example.com");\n\n   foreach (var link in dom["a[href]"])\n   {\n       Console.WriteLine(link.GetAttribute("href"));\n   }