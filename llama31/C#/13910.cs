var foreignKeyReferencesExist = dbContext.Section\n    .Where(s => s.Id == sectionId)\n    .Any(s => s.Projects.Any() || s.Categories.Any() || s.OtherTable1.Any() || s.OtherTable2.Any());\n\nif (foreignKeyReferencesExist)\n{\n    // Inform the user that the record cannot be deleted\n}\nelse\n{\n    // Delete the record\n}