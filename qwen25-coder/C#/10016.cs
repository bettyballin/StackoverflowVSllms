using NHibernate;\nusing System.Data.SqlClient; // Or whatever your specific ADO.NET provider is\n\ntry\n{\n    using (var transaction = session.BeginTransaction())\n    {\n        session.Save(entity);\n        transaction.Commit();\n    }\n}\ncatch (GenericADOException ex) when (ex.InnerException is SqlException sqlEx)\n{\n    if (sqlEx.Number == 2601 || sqlEx.Number == 2627)\n    {\n        // Handle unique constraint violation, e.g., ask the user to choose another value\n        Console.WriteLine("Unique constraint violated. Please choose a different name.");\n    }\n    else\n    {\n        // Handle other database errors\n        throw;\n    }\n}\ncatch (Exception ex)\n{\n    // Handle unexpected exceptions\n    throw;\n}