using System;\nusing System.Data;\nusing System.Data.SqlClient;\n\nclass DatabaseSyncer\n{\n    private string sourceConnString = "your_source_connection_string";\n    private string destConnString = "your_destination_connection_string";\n\n    public void SyncDatabases()\n    {\n        DataTable sourceTable = FetchDataFromSource();\n        InsertOrUpdateInDestination(sourceTable);\n    }\n\n    private DataTable FetchDataFromSource()\n    {\n        using (SqlConnection connection = new SqlConnection(sourceConnString))\n        {\n            SqlDataAdapter adapter = new SqlDataAdapter("SELECT * FROM YourTableName", connection);\n            DataTable table = new DataTable();\n            adapter.Fill(table);\n            return table;\n        }\n    }\n\n    private void InsertOrUpdateInDestination(DataTable sourceTable)\n    {\n        using (SqlConnection connection = new SqlConnection(destConnString))\n        {\n            SqlCommandBuilder commandBuilder = new SqlCommandBuilder(new SqlDataAdapter("SELECT * FROM YourTableName", connection));\n            SqlDataAdapter adapter = new SqlDataAdapter(commandBuilder.SelectCommand);\n            adapter.InsertCommand = commandBuilder.GetInsertCommand();\n            adapter.UpdateCommand = commandBuilder.GetUpdateCommand();\n\n            // Open the connection for updating.\n            connection.Open();\n\n            // Update the database table with data from the local DataTable.\n            int rowsUpdated = adapter.Update(sourceTable);\n\n            Console.WriteLine($"{rowsUpdated} rows updated.");\n        }\n    }\n\n    static void Main(string[] args)\n    {\n        new DatabaseSyncer().SyncDatabases();\n    }\n}