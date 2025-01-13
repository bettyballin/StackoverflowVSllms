using FluentNHibernate.Cfg;\n   using FluentNHibernate.Cfg.Db;\n   using NHibernate.Cfg;\n\n   public Configuration CreateFluentNHibernateConfig()\n   {\n       return Fluently.Configure()\n           .Database(MsSqlConfiguration.MsSql2012\n               .ConnectionString(c => c\n                   .Server("your_server")\n                   .Database("your_database")\n                   .Username("your_username")\n                   .Password("your_password")))\n           .Mappings(m => m.FluentMappings.AddFromAssemblyOf<YourEntityMap>())\n           .BuildConfiguration();\n   }