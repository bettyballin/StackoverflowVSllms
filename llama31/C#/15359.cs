using (var db = new MyDbContext())\n{\n    db.Database.Log = Console.Out; // or db.Database.Log = new StringWriter(sb); to log to a string\n    // ...\n    db.SaveChanges();\n}