var cfg = new Configuration();\n   cfg.DataBaseIntegration(db =>\n   {\n       db.ConnectionString = "Data Source=mydatabase.db;Version=3;";\n       db.Dialect<NHibernate.Dialect.SQLiteDialect>();\n   });\n\n   var schemaUpdate = new SchemaUpdate(cfg);\n   schemaUpdate.Execute(false, true);