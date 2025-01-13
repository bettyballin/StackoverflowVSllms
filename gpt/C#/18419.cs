using (var updateContext = new YourDataContext())\n   {\n       // Perform the high-performance SQL update\n       updateContext.Database.ExecuteSqlCommand("UPDATE [table] SET [column] = [value] WHERE [predicate]");\n   }\n   \n   // Optionally, refresh the original context if needed\n   originalContext.ChangeTracker.Clear();\n   var updatedEntities = originalContext.YourEntities.Where(predicate).ToList();