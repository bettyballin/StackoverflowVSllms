SqlDataAdapter da = new SqlDataAdapter();\nda.SelectCommand = new SqlCommand("YourStoredProcedureName", YourSqlConnection);\nda.SelectCommand.CommandType = CommandType.StoredProcedure;\n\nDataSet ds = new DataSet();\nda.TableMappings.Add("Table", "D1Header"); // assuming the last table is the one you want to rename\nda.Fill(ds);