using System.Data.SqlClient;\n\n// Your HTML string\nstring html = "<b>demo</b>";\n\n// Create a connection to your SQL Server\nSqlConnection connection = new SqlConnection("Your Connection String");\n\n// Create a command with a parameterized query\nSqlCommand command = new SqlCommand("Insert Into YourTable (HtmlColumn) Values (@Html)", connection);\n\n// Add the HTML parameter\ncommand.Parameters.AddWithValue("@Html", html);\n\n// Execute the command\nconnection.Open();\ncommand.ExecuteNonQuery();\nconnection.Close();