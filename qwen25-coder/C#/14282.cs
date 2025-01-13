using System;\nusing System.Data;\nusing System.Data.SqlClient;\n\nclass Program\n{\n    static void Main()\n    {\n        using (SqlConnection conn = new SqlConnection("your_connection_string_here"))\n        {\n            SqlDataAdapter adapter = new SqlDataAdapter();\n            SqlCommand command = new SqlCommand("YourStoredProcedureName", conn)\n            {\n                CommandType = CommandType.StoredProcedure\n            };\n\n            DataSet ds = new DataSet();\n            adapter.SelectCommand = command;\n            adapter.Fill(ds);\n\n            // Assuming the DataTable you want to rename is always the last one.\n            if (ds.Tables.Count > 0)\n            {\n                ds.Tables[ds.Tables.Count - 1].TableName = "D1Header";\n            }\n\n            // Now ds.Tables["D1Header"] will give you your desired table.\n        }\n    }\n}