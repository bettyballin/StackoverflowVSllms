using (var conn = new System.Data.SqlClient.SqlConnection("Data Source=.;Initial Catalog=DBNAME;Integrated Security=True;Pooling=false"))\n{\n    conn.Open();\n    var cmd = conn.CreateCommand();\n    cmd.CommandText = "UPDATE ...";\n    cmd.ExecuteNonQuery();\n}\n\nstring sql = "Alter Database DBNAME set single_user with rollback immediate drop database DBNAME";\nvar server = new Microsoft.SqlServer.Management.Smo.Server(".");\nserver.ConnectionContext.ExecuteNonQuery(sql);\nserver.ConnectionContext.Disconnect();\n\nsql = File.ReadAllText("PathToDotSqlFile...");\nserver = new Microsoft.SqlServer.Management.Smo.Server(".");\nserver.ConnectionContext.ExecuteNonQuery(sql);\nserver.ConnectionContext.Disconnect();\n\nusing (var conn = new System.Data.SqlClient.SqlConnection("Data Source=.;Initial Catalog=WER_CONFIG;Integrated Security=True;Pooling=false"))\n{\n    conn.Open();\n    var cmd = conn.CreateCommand();\n    cmd.CommandText = "UPDATE ...";\n    cmd.ExecuteNonQuery();\n}