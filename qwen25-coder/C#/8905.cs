using (var context = new YourDbContext())\n{\n    var entities = context.YourEntities.Include(e => e.RelatedEntity).ToList();\n}