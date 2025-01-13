public static void AddMessage(string callID, string content)\n{\n    string insertQuery = \n        "INSERT INTO Sporocilo (oznaka_klica, smer, vsebina, prebrano, cas_zapisa) VALUES (@callId, 0, @content, 0, @insertTime)";\n    \n    using (SqlCommand cmd = new SqlCommand(insertQuery, conn))\n    {\n        cmd.Parameters.AddWithValue("@callId", callID);\n        cmd.Parameters.AddWithValue("@content", content);\n        cmd.Parameters.AddWithValue("@insertTime", "2008-10-10"); // Correct date format for SQL Server\n\n        try\n        {\n            if (conn.State != ConnectionState.Open)\n                conn.Open();\n\n            int rowsAffected = cmd.ExecuteNonQuery(); // Use ExecuteNonQuery for insert operations\n            \n            Console.WriteLine($"{rowsAffected} row(s) inserted."); // Optional: Log the number of rows affected\n        }\n        catch (Exception ex)\n        {\n            // Properly log exception details\n            Console.WriteLine("An error occurred: " + ex.Message);\n            throw new InvalidOperationException("Failed to add message", ex);\n        }\n    } // Using statement automatically closes the connection here.\n}