var configuration = new Configuration();\n    // Configure NHibernate (e.g., from app.config or manually)\n\n    var schemaUpdate = new SchemaUpdate(configuration);\n    schemaUpdate.Execute(true, true);