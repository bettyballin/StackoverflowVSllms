using System;\nusing System.Data;\nusing System.Configuration;\nusing System.Data.SqlClient;\n\nclass Program\n{\n    static void Main()\n    {\n        string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            SqlCommand command = new SqlCommand("SELECT * FROM Table1; SELECT * FROM Table2 /* Repeat for each table */", connection);\n            SqlDataAdapter adapter = new SqlDataAdapter(command);\n            DataSet dataSet = new DataSet();\n            \n            // Fill the dataset\n            adapter.Fill(dataSet);\n\n            // Process the data\n            foreach (DataRow row in dataSet.Tables[0].Rows)\n            {\n                // Example processing logic\n                Console.WriteLine(row["ColumnName"].ToString());\n            }\n        }\n    }\n}