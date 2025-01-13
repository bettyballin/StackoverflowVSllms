using (var context = new YourDataContext())\n   {\n       // Perform the high-performance SQL update\n       context.Database.ExecuteSqlCommand("UPDATE [table] SET [column] = [value] WHERE [predicate]");\n       \n       // Manually update the in-memory objects\n       var entitiesToUpdate = context.YourEntities.Where(predicate).ToList();\n       foreach (var entity in entitiesToUpdate)\n       {\n           entity.Column = newValue;\n           context.Entry(entity).State = EntityState.Modified;\n       }\n       context.SaveChanges();\n   }