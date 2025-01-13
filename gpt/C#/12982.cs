using FluentNHibernate.Cfg;\nusing FluentNHibernate.Cfg.Db;\nusing NHibernate;\nusing System.Reflection;\n\npublic ISessionFactory CreateSessionFactory()\n{\n    var cfg = Fluently.Configure()\n        .Database(MsSqlConfiguration.MsSql2005\n            .ConnectionString(c => c\n                .TrustedConnection()\n                .Server("localhost")\n                .Database("LDTT")))\n        .Mappings(m => m.FluentMappings\n            .AddFromAssembly(Assembly.GetExecutingAssembly()))\n        .ExposeConfiguration(BuildSchema)\n        .BuildSessionFactory();\n\n    return cfg;\n}\n\nprivate void BuildSchema(NHibernate.Cfg.Configuration config)\n{\n    new NHibernate.Tool.hbm2ddl.SchemaExport(config)\n        .Create(false, true);\n}