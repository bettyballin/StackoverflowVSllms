// Example of basic setup for NHibernate in C#\nvar sessionFactory = new Configuration()\n    .Configure("hibernate.cfg.xml")\n    .AddAssembly(Assembly.GetExecutingAssembly())\n    .BuildSessionFactory();\nusing (ISession session = sessionFactory.OpenSession())\n{\n    // Use the session to interact with the database\n}