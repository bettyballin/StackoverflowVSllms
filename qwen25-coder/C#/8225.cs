using System;\nusing Oracle.ManagedDataAccess.Client;\n\nclass Program\n{\n    static void Main()\n    {\n        // Connection String to connect to the Oracle Database\n        string connectionString = "User Id=your_user_id;Password=your_password;Data Source=your_database_service_name;";\n\n        using (OracleConnection connection = new OracleConnection(connectionString))\n        {\n            try\n            {\n                connection.Open();\n                Console.WriteLine("Connected to Oracle database successfully.");\n                \n                // Perform your data operations here\n\n            }\n            catch (Exception ex)\n            {\n                Console.WriteLine($"An error occurred: {ex.Message}");\n            }\n            finally\n            {\n                connection.Close();\n            }\n        }\n    }\n}