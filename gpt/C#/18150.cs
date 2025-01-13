using (var session = sessionFactory.OpenSession())\n   using (var transaction = session.BeginTransaction())\n   {\n       try\n       {\n           // Perform a single operation\n           transaction.Commit();\n       }\n       catch\n       {\n           transaction.Rollback();\n           throw;\n       }\n   }