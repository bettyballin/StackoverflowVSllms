using System;\nusing System.Data.SqlClient;\nusing System.Threading;\n\npublic class TestFramework\n{\n    private static string connectionString = "YourConnectionStringHere";\n\n    public void WaitForService()\n    {\n        while (true)\n        {\n            string status = GetStatus();\n            if (status == "Completed")\n            {\n                Console.WriteLine("Service has completed its task.");\n                break;\n            }\n\n            // Wait for a while before polling again\n            Thread.Sleep(1000);\n        }\n    }\n\n    private string GetStatus()\n    {\n        using (SqlConnection connection = new SqlConnection(connectionString))\n        {\n            connection.Open();\n            string query = "SELECT Status FROM ServiceStatus WHERE Id = 1";\n            using (SqlCommand command = new SqlCommand(query, connection))\n            {\n                return command.ExecuteScalar()?.ToString();\n            }\n        }\n    }\n}