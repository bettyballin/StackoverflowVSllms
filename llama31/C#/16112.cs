using System;\nusing System.Data;\nusing System.Data.SqlClient;\nusing System.Linq;\n\npublic class OrderRepository\n{\n    private string connectionString;\n\n    public OrderRepository(string connectionString)\n    {\n        this.connectionString = connectionString;\n    }\n\n    public DataTable GetOrderDetails(List<string> orderNumbers)\n    {\n        DataTable dt = new DataTable();\n\n        // Create parameter string like "@parm1, @parm2, @parm3"\n        string parameterString = string.Join(", ", orderNumbers.Select((s, i) => $"@parm{i}"));\n\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n\n            // Create a command with a parameterized query\n            SqlCommand command = new SqlCommand($"SELECT * FROM Orders WHERE OrderNumber IN ({parameterString})", connection);\n\n            // Add the parameters to the command\n            for (int i = 0; i < orderNumbers.Count; i++)\n            {\n                command.Parameters.AddWithValue($"@parm{i}", orderNumbers[i]);\n            }\n\n            // Execute the query\n            SqlDataAdapter adapter = new SqlDataAdapter(command);\n            adapter.Fill(dt);\n        }\n\n        return dt;\n    }\n}