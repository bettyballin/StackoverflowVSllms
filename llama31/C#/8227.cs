using Dapper;\n\n// assuming you have a connection string and a list of objects to insert\nstring connectionString = "your connection string";\nList<YourObject> objectsToInsert = new List<YourObject>();\n\nusing (SqlConnection connection = new SqlConnection(connectionString))\n{\n    connection.Open();\n\n    string sql = "INSERT INTO YourTable (Column1, Column2, Column3) VALUES (@Column1, @Column2, @Column3)";\n    connection.Execute(sql, objectsToInsert);\n}