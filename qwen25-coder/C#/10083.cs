using System;\nusing System.Collections.Generic;\nusing System.Data.SqlClient;\n\nclass Program\n{\n    private static SqlConnection sqlConnection = new SqlConnection();\n\n    private static void OpenConn()\n    {\n        sqlConnection.ConnectionString = Properties.Settings.Default.ConnStr;\n        sqlConnection.Open();\n    }\n\n    static void Main(string[] args)\n    {\n        string query = Console.ReadLine();\n        OpenConn();\n        SqlCommand command = new SqlCommand(query, sqlConnection);\n        using (SqlDataReader reader = command.ExecuteReader())\n        {\n            if (reader.HasRows)\n            {\n                // Read and print column names\n                for (int i = 0; i < reader.FieldCount; i++)\n                {\n                    Console.Write("| {0} ", reader.GetName(i));\n                }\n                Console.WriteLine();\n\n                while (reader.Read())\n                {\n                    for (int i = 0; i < reader.FieldCount; i++)\n                    {\n                        // Using LINQ to process each value, though not necessary here\n                        var value = Enumerable.Repeat(reader.GetValue(i), 1).FirstOrDefault();\n                        Console.Write("| {0} ", value);\n                    }\n                    Console.WriteLine();\n                }\n            }\n        }\n    }\n}