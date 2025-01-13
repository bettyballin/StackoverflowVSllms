using (var session = sessionFactory.OpenSession())\n{\n    int pageNumber = 2; // page you want to load, starting at 1\n    int pageSize = 10;   // number of results per page\n\n    var results = session.Query<YourEntity>()\n                         .Skip((pageNumber - 1) * pageSize)\n                         .Take(pageSize)\n                         .ToList();\n    \n    // Bind `results` to your GridView control here\n}