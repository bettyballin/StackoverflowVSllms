using (var context = new AccessDbContext())\n   {\n       var query = from table in context.YourTable\n                   where table.SomeColumn == "SomeValue"\n                   select table;\n\n       foreach (var item in query)\n       {\n           Console.WriteLine(item.YourColumn);\n       }\n   }