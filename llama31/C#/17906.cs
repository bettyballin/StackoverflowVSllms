var SQL = $"SELECT * FROM {TABLE} WHERE {NAME} LIKE @param";\ncmd.Parameters.AddWithValue("@param", $"%JOHN%");