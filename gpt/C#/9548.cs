using System;\nusing System.Data;\nusing System.Data.OleDb;\n\npublic class SqlQueryExample\n{\n    public void ExecuteQuery()\n    {\n        OleDbConnection connection = new OleDbConnection();\n        connection.ConnectionString = "...";\n        connection.Open();\n        \n        OleDbCommand cmd = new OleDbCommand();\n        cmd.Connection = connection;\n        cmd.CommandText = "select * from myTable where (myColumn = ? OR (myColumn IS NULL AND ? IS NULL))";\n        \n        OleDbParameter parameter1 = cmd.Parameters.Add("myColumn", OleDbType.Integer);\n        OleDbParameter parameter2 = cmd.Parameters.Add("myColumnCheck", OleDbType.Integer);\n        \n        parameter1.DbType = DbType.Int32;\n        parameter1.IsNullable = true;\n        parameter2.DbType = DbType.Int32;\n        parameter2.IsNullable = true;\n\n        int? nullableValue = null; // or set your value here\n        parameter1.Value = (object)nullableValue ?? DBNull.Value;\n        parameter2.Value = (object)nullableValue ?? DBNull.Value;\n\n        var reader = cmd.ExecuteReader();\n        while (reader.Read())\n        {\n            // Process each row\n        }\n\n        reader.Close();\n        connection.Close();\n    }\n}