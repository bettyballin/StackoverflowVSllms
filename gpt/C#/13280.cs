using (var context = new MyDataContext())\n{\n    var entity = context.MyEntities.FirstOrDefault(e => e.Id == someId);\n    if (entity != null)\n    {\n        // Update the entity\n        entity.Value = "New Value";\n\n        // Call stored procedure with both new and old values\n        context.ExecuteCommand("EXEC UpdateMyTable @Id, @NewValue, @OldValue",\n            new SqlParameter("@Id", entity.Id),\n            new SqlParameter("@NewValue", entity.Value),\n            new SqlParameter("@OldValue", entity.GetOriginalValue()));\n    }\n}