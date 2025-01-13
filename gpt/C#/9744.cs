using System;\nusing System.Data.SqlClient;\n\npublic void ExecuteDatabaseOperation()\n{\n    SqlConnection connection = null;\n\n    try\n    {\n        connection = new SqlConnection("your_connection_string_here");\n        connection.Open();\n\n        // Perform database operations\n    }\n    finally\n    {\n        if (connection != null)\n        {\n            connection.Close();\n        }\n    }\n}