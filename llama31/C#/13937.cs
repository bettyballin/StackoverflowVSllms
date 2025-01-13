using Microsoft.EntityFrameworkCore;\n\n// Assume 'dataset' is your disconnected dataset\nDataSet dataset = ...;\n\n// Create a DbContext instance\nvar context = new MyContext();\n\n// Create the model from the dataset\ncontext.Model.AddEntityType("MyEntity", entityType =>\n{\n    entityType.HasKey("Id");\n    entityType.ToTable("MyTable");\n});\n\n// Use the model\nvar myEntities = context.Set<MyEntity>().ToList();