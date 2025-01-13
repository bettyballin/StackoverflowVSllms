using System;\nusing System.Configuration;\nusing System.Data;\nusing System.Data.Common;\n\npublic class DataAccessLayer\n{\n    private readonly string _connectionString;\n    private readonly string _providerName;\n\n    public DataAccessLayer(string connectionStringName)\n    {\n        var connectionStringSettings = ConfigurationManager.ConnectionStrings[connectionStringName];\n        _connectionString = connectionStringSettings.ConnectionString;\n        _providerName = connectionStringSettings.ProviderName;\n    }\n\n    private DbConnection CreateConnection()\n    {\n        var factory = DbProviderFactories.GetFactory(_providerName);\n        var connection = factory.CreateConnection();\n        connection.ConnectionString = _connectionString;\n        return connection;\n    }\n\n    public DataTable ExecuteQuery(string queryKey, params DbParameter[] parameters)\n    {\n        string query = ConfigurationManager.AppSettings[queryKey];\n        using (var connection = CreateConnection())\n        using (var command = connection.CreateCommand())\n        {\n            command.CommandText = query;\n            command.Parameters.AddRange(parameters);\n\n            var dataTable = new DataTable();\n            var adapter = DbProviderFactories.GetFactory(_providerName).CreateDataAdapter();\n            adapter.SelectCommand = command;\n            adapter.Fill(dataTable);\n            return dataTable;\n        }\n    }\n\n    public int ExecuteNonQuery(string queryKey, params DbParameter[] parameters)\n    {\n        string query = ConfigurationManager.AppSettings[queryKey];\n        using (var connection = CreateConnection())\n        using (var command = connection.CreateCommand())\n        {\n            command.CommandText = query;\n            command.Parameters.AddRange(parameters);\n            connection.Open();\n            return command.ExecuteNonQuery();\n        }\n    }\n}