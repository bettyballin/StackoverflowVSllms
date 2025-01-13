// Example usage:\nusing NHibernate;\nusing NHibernate.Cfg;\n\nclass MyClass {\n    public virtual int Id { get; set; }\n    public virtual string Name { get; set; }\n}\n\n// Create a NHibernate session factory\nvar sessionFactory = new Configuration()\n    .AddAssembly(typeof(MyClass).Assembly)\n    .BuildSessionFactory();\n\n// Open a session and retrieve data\nusing (var session = sessionFactory.OpenSession()) {\n    var myObjects = session.CreateCriteria<MyClass>().List<MyClass>();\n}