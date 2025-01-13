using Dapper;\n\n// ...\n\nvar employees = new[]\n{\n    new Employee { ID = 5, Name = "Frank Grimes" },\n    new Employee { ID = 6, Name = "Tim O'Reilly" }\n};\n\nvar sqlStatements = new List<string>();\n\nforeach (var employee in employees)\n{\n    var sql = "INSERT INTO Employees (id, name) VALUES (@id, @name)";\n    var parameters = new { id = employee.ID, name = employee.Name };\n    var statement = Dapper.SqlMapper.GenerateSqlStatement(sql, parameters);\n    sqlStatements.Add(statement);\n}