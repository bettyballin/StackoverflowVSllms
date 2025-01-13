using (SqlConnection conn = new SqlConnection("your_connection_string"))\n{\n    try\n    {\n        conn.Open();\n        // Execute your command here, e.g., SqlCommand\n    }\n    catch (SqlException ex)\n    {\n        // Handle exception\n        Console.WriteLine(ex.Message);\n    }\n    finally\n    {\n        // Ensure the connection is closed even if an error occurs.\n        if (conn.State == System.Data.ConnectionState.Open)\n        {\n            conn.Close();\n        }\n    }\n}