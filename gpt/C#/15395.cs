using System;\nusing System.Data;\nusing System.Data.SqlClient;\n\npublic bool AreDatabasesEqual(string connectionString1, string connectionString2)\n{\n    DataTable tableHashes1 = GetTableHashes(connectionString1);\n    DataTable tableHashes2 = GetTableHashes(connectionString2);\n\n    // Compare the results\n    if (tableHashes1.Rows.Count != tableHashes2.Rows.Count)\n    {\n        return false;\n    }\n\n    foreach (DataRow row1 in tableHashes1.Rows)\n    {\n        DataRow[] matchingRows = tableHashes2.Select($"TableName = '{row1["TableName"]}' AND TableHash = '{row1["TableHash"]}'");\n        if (matchingRows.Length != 1)\n        {\n            return false;\n        }\n    }\n\n    return true;\n}\n\nprivate DataTable GetTableHashes(string connectionString)\n{\n    using (SqlConnection conn = new SqlConnection(connectionString))\n    {\n        using (SqlCommand cmd = new SqlCommand("GenerateTableHashes", conn))\n        {\n            cmd.CommandType = CommandType.StoredProcedure;\n            conn.Open();\n\n            using (SqlDataAdapter da = new SqlDataAdapter(cmd))\n            {\n                DataTable dt = new DataTable();\n                da.Fill(dt);\n                return dt;\n            }\n        }\n    }\n}