var entries = context.ChangeTracker.Entries<MyEntity>();\nforeach (var entry in entries)\n{\n    if (entry.State == EntityState.Added)\n    {\n        Console.WriteLine(entry.Entity.Name);\n    }\n}