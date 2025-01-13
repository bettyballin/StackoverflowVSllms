using (ITransaction transaction = session.BeginTransaction())\n{\n    try\n    {\n        // Perform NHibernate query\n        transaction.Commit();\n    }\n    catch (Exception ex)\n    {\n        transaction.Rollback();\n    }\n}