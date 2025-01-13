using System;\nusing System.Data;\nusing System.Data.SqlClient;\n\npublic class BulkUploadExample\n{\n    public void BulkUpload(DataTable dataTable, string connectionString)\n    {\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n\n            using (SqlBulkCopy bulkCopy = new SqlBulkCopy(connection))\n            {\n                bulkCopy.DestinationTableName = "YourTableName";\n                bulkCopy.WriteToServer(dataTable);\n            }\n        }\n    }\n}