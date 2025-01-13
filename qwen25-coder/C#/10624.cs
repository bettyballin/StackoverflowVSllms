using (OracleConnection conn = new OracleConnection(ConnectionString))\n{\n    using (OracleCommand cmd = new OracleCommand($"{ApplicationSchema}.bookmarks.procGet_Bookmark_Id", conn))\n    {\n        cmd.CommandType = CommandType.StoredProcedure;\n\n        // Define an output parameter for bookmarkId\n        OracleParameter bookmarkParam = new OracleParameter("bookmarkId", OracleDbType.Decimal);\n        bookmarkParam.Direction = ParameterDirection.Output;\n        cmd.Parameters.Add(bookmarkParam);\n\n        conn.Open();\n        cmd.ExecuteNonQuery();\n\n        // After the procedure executes, you can get the value of the output parameter\n        int bookmarkId = Convert.ToInt32(bookmarkParam.Value);\n        Console.WriteLine($"Generated Bookmark ID: {bookmarkId}");\n    }\n}