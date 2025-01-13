using (var connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n    using (var transaction = connection.BeginTransaction())\n    {\n        using (var cmd = connection.CreateCommand())\n        {\n            cmd.Transaction = transaction;\n            var sql = new StringBuilder("INSERT INTO MyTable (id, name, salary) VALUES ");\n            var parameters = new List<SqlParameter>();\n\n            for (int i = 0; i < employees.Count; i++)\n            {\n                sql.Append($"(@id{i}, @name{i}, @salary{i}),");\n                parameters.Add(new SqlParameter($"@id{i}", employees[i].ID));\n                parameters.Add(new SqlParameter($"@name{i}", employees[i].Name));\n                parameters.Add(new SqlParameter($"@salary{i}", employees[i].Salary));\n            }\n\n            // Remove the last comma and add a semicolon\n            sql.Length--;\n            sql.Append(";");\n\n            cmd.CommandText = sql.ToString();\n            cmd.Parameters.AddRange(parameters.ToArray());\n\n            try\n            {\n                cmd.ExecuteNonQuery();\n                transaction.Commit();\n            }\n            catch\n            {\n                transaction.Rollback();\n                throw;\n            }\n        }\n    }\n}