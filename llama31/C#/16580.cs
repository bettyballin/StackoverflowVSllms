using (var dbContext = new YourDataContext())\n{\n    // Retrieve the entity\n    var entity = dbContext.YourTable.FirstOrDefault(e => e.Id == yourId);\n    \n    if (entity != null)\n    {\n        // Refresh the entity from the database, overwriting local changes\n        // This step ensures we have the latest values from the database\n        dbContext.Refresh(System.Data.Linq.RefreshMode.OverwriteCurrentValues, entity);\n        \n        // Update the specific column\n        entity.YourColumn = yourNewValue;\n        \n        try\n        {\n            // Submit changes\n            dbContext.SubmitChanges();\n        }\n        catch (ChangeConflictException)\n        {\n            // Handle the case where even the targeted column has been changed\n        }\n    }\n}