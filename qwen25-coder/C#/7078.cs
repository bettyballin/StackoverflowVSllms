IQuery query = QueryBuilder.Build("Employees",\n                                  null,\n                                  new[] { "Age > 30" },\n                                  "Name, Department",\n                                  "Salary DESC");