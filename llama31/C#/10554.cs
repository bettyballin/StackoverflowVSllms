sql = "SELECT TOP 10 * FROM YourTable WHERE YourColumn = @param"\ncommand.Parameters.AddWithValue("@param", "your_value")