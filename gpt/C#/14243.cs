// Combine all object IDs into a single query using IN statement\nvar objectIds = string.Join(",", objects.Select(o => o.ID));\n\n// Combined query for Table1\nstring query1 = $"SELECT * FROM Table1 WHERE ObjectID IN ({objectIds})";\n\n// Combined query for Table2\nstring query2 = $"SELECT * FROM Table2 WHERE ObjectID IN ({objectIds})";\n\n// Execute combined queries and process the data