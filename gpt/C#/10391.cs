using System;\nusing System.Data;\nusing System.Data.OleDb;\nusing Dapper;\n\npublic class Program\n{\n    public static void Main()\n    {\n        string connectionString = "Your OleDb connection string here";\n        using (IDbConnection db = new OleDbConnection(connectionString))\n        {\n            var parameters = new DynamicParameters();\n            parameters.Add("@Parameter1", value1);\n            parameters.Add("@Parameter2", value2);\n            // Add other parameters as needed\n\n            db.Execute("YourStoredProcedureName", parameters, commandType: CommandType.StoredProcedure);\n        }\n    }\n}