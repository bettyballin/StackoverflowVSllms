using (var dc = new YourDataContext())\n{\n    var result = from row in dc.Table\n                 select new { NoWav = row.Wav == null };\n\n    foreach (var item in result)\n    {\n        Console.WriteLine(item.NoWav ? "No Wav" : "Wav Exists");\n    }\n}