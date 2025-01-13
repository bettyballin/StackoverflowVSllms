// Configure your NHibernate SessionFactory (usually done once at application startup)\nvar sessionFactory = new Configuration()\n    .Configure("hibernate.cfg.xml")\n    .BuildSessionFactory();\n\n// Per client request setup\nusing (ISession session = sessionFactory.OpenSession())\n{\n    using (ITransaction transaction = session.BeginTransaction())\n    {\n        try\n        {\n            // Perform operations on the database through the session\n            var player = session.Get<Player>(playerId);\n            player.UpdatePosition(newX, newY);\n            \n            // More operations...\n            \n            // Commit the transaction\n            transaction.Commit();\n        }\n        catch (Exception ex)\n        {\n            // Rollback in case of any exceptions\n            transaction.Rollback();\n            throw;\n        }\n    } // Session and transaction are automatically closed and disposed here\n}