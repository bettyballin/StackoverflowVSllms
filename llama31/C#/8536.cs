using (var dbContext = new MyDbContext())\n{\n    var customers = dbContext.Customers\n        .Where(c => c.Country == "USA")\n        .OrderBy(c => c.Name)\n        .ToList();\n}