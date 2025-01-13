using NHibernate;\nusing NHibernate.Cfg;\nusing NHibernate.Tool.hbm2ddl;\nusing System.Collections.Generic;\n\npublic class Program\n{\n    public static void Main(string[] args)\n    {\n        var cfg = new Configuration();\n        cfg.Configure(); // Configure NHibernate with hibernate.cfg.xml\n\n        // Add your mappings here\n        // cfg.AddAssembly(typeof(YourEntityClass).Assembly);\n\n        var sessionFactory = cfg.BuildSessionFactory();\n\n        using (var session = sessionFactory.OpenSession())\n        {\n            // Example of creating a raw SQL query\n            var sqlQuery = session.CreateSQLQuery("SELECT * FROM YourTable WHERE YourColumn = :param")\n                                  .SetParameter("param", "value");\n\n            // Execute the query and get the result as list of objects\n            var result = sqlQuery.List<object>();\n\n            // Process the result\n            foreach (var item in result)\n            {\n                // Handle each item\n            }\n        }\n    }\n}