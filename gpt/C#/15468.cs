var configuration = new Configuration();\nconfiguration.Configure(); // Configure NHibernate from hibernate.cfg.xml or other source\n\nstring schema = "xyz"; // Specify your schema here\nif (configuration.Properties[NHibernate.Cfg.Environment.ConnectionDriver] == "NHibernate.Driver.SQLite20Driver")\n{\n    schema = ""; // SQLite does not support schemas\n}\n\nconfiguration.SetNamingStrategy(new CustomNamingStrategy(schema));