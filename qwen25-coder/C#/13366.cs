using System;\nusing System.Data.SqlClient;\n\nclass Program\n{\n    static void Main()\n    {\n        string connectionString = "your_connection_string_here";\n        using (SqlConnection conn = new SqlConnection(connectionString))\n        {\n            try\n            {\n                conn.Open();\n                using (SqlCommand cmd = new SqlCommand("SELECT session_id, encrypt_option FROM sys.dm_exec_connections WHERE session_id = @@SPID", conn))\n                {\n                    SqlDataReader reader = cmd.ExecuteReader();\n                    if (reader.Read())\n                    {\n                        string encryptOption = reader["encrypt_option"].ToString();\n                        Console.WriteLine($"Encrypt Option: {encryptOption}");\n                    }\n                }\n            }\n            catch (Exception ex)\n            {\n                Console.WriteLine(ex.Message);\n            }\n        }\n    }\n}