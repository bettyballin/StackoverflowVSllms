using (var session = sessionFactory.OpenSession())\n{\n    var entity = session.Get<Entity>(1);\n    Console.WriteLine(entity.Name);\n}