using (var db = Database.Context)\n{\n    try\n    {\n        var root = (from post in db.Post\n                    where post.Id == rootPostId\n                    select post).Single();\n\n        root.LastActivityUtc = DateTime.UtcNow;\n\n        db.SubmitChanges();\n    }\n    catch (ChangeConflictException)\n    {\n        // Refresh the conflicting entities from the database\n        db.ChangeConflicts.ResolveAll(RefreshMode.OverwriteCurrentValues);\n        \n        // Optionally, you might want to log the conflict or handle it in another way\n    }\n}