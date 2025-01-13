using System.Collections.Generic;\nusing System.Data.SqlClient;\n\npublic IEnumerable<MyObject> GetMyObjects(string connectionString)\n{\n    using (var connection = new SqlConnection(connectionString))\n    {\n        var command = connection.CreateCommand();\n        command.CommandText = "SELECT Id, Name FROM MyTable";\n        \n        connection.Open();\n\n        using (var reader = command.ExecuteReader())\n        {\n            while (reader.Read())\n            {\n                yield return new MyObject\n                {\n                    Id = reader.GetInt32(0),\n                    Name = reader.GetString(1)\n                };\n            }\n        }\n    }\n}\n\npublic class MyObject\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n}