// Define the NHibernate configuration and mapping\npublic class MyEntity\n{\n    public virtual int Id { get; set; }\n    public virtual string Name { get; set; }\n}\n\npublic class MyEntityMap : ClassMap<MyEntity>\n{\n    public MyEntityMap()\n    {\n        Id(x => x.Id);\n        Map(x => x.Name);\n    }\n}\n\n// Create a session factory and use it\nISessionFactory sessionFactory = Fluently.Configure()\n    .Database(MsSqlConfiguration.MsSql2008.ConnectionString("..."))\n    .Mappings(m => m.FluentMappings.AddFromAssembly(typeof(MyEntityMap).Assembly))\n    .BuildSessionFactory();\n\nISession session = sessionFactory.OpenSession();\nMyEntity entity = session.Get<MyEntity>(1);