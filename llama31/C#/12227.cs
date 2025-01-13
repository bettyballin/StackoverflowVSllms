using (var dc = new DataContext())\n{\n    using (var transaction = dc.Connection.BeginTransaction())\n    {\n        try\n        {\n            // Delete old specs\n            dc.ProductSpecs.DeleteAllOnSubmit(oldSpecs);\n\n            // Insert new specs\n            foreach (var spec in newSpecs)\n            {\n                dc.ProductSpecs.InsertOnSubmit(spec);\n            }\n\n            dc.SubmitChanges();\n            transaction.Commit();\n        }\n        catch\n        {\n            transaction.Rollback();\n            throw;\n        }\n    }\n}