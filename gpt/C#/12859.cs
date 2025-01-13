using NHibernate;\nusing NHibernate.Cfg;\n\n// Configuration\nConfiguration cfg = new Configuration();\ncfg.Configure(); // Assumes you have NHibernate configuration in hibernate.cfg.xml\n\n// Build session factory\nISessionFactory sessionFactory = cfg.BuildSessionFactory();\n\n// Open session\nusing (ISession session = sessionFactory.OpenSession())\n{\n    // Begin transaction\n    using (ITransaction transaction = session.BeginTransaction())\n    {\n        try\n        {\n            // Create new entity to insert\n            var entity = new YourEntity\n            {\n                Property1 = "Value1",\n                Property2 = "Value2"\n            };\n\n            // Save entity\n            session.Save(entity);\n\n            // Commit transaction\n            transaction.Commit();\n        }\n        catch (Exception ex)\n        {\n            // Rollback transaction in case of error\n            transaction.Rollback();\n            throw;\n        }\n    }\n}