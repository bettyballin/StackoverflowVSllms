Command = new OracleCommand();\nCommand.CommandText = "FII_DBO.CLEAR_UNIT_TEST_PRODUCT"; // Include the schema name\nCommand.CommandType = CommandType.StoredProcedure;\nCommand.Connection = connection;\nCommand.ExecuteNonQuery();