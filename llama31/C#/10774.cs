var query = session.Query<Entity>()\n    .FetchMany(e => e.Relationship1)\n    .FetchMany(e => e.Relationship2)\n    .ToList();