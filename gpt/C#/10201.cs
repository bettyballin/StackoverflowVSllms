public class DataAccessLayer\n{\n    private readonly string _connectionString;\n\n    public DataAccessLayer(string connectionString)\n    {\n        _connectionString = connectionString;\n    }\n\n    public DataSet FillDataset(string cmd, CommandType cmdType, SqlParameter[] parameters = null)\n    {\n        using (var connection = new SqlConnection(_connectionString))\n        using (var command = new SqlCommand(cmd, connection))\n        using (var sqlda = new SqlDataAdapter(command))\n        {\n            command.CommandType = cmdType;\n            if (parameters != null)\n            {\n                command.Parameters.AddRange(parameters);\n            }\n\n            var res = new DataSet();\n\n            try\n            {\n                sqlda.Fill(res);\n            }\n            catch (Exception ex)\n            {\n                // Log exception\n                throw; // Consider rethrowing or handling the exception appropriately\n            }\n\n            return res;\n        }\n    }\n\n    public object ExecuteNonQuery(string spname, params SqlParameter[] parameterValues)\n    {\n        using (var connection = new SqlConnection(_connectionString))\n        using (var command = new SqlCommand(spname, connection))\n        {\n            command.CommandType = CommandType.StoredProcedure;\n            command.Parameters.AddRange(parameterValues);\n\n            try\n            {\n                connection.Open();\n                command.ExecuteNonQuery();\n                return command.Parameters[command.Parameters.Count - 1].Value;\n            }\n            catch (Exception ex)\n            {\n                // Log exception\n                throw; // Consider rethrowing or handling the exception appropriately\n            }\n        }\n    }\n}