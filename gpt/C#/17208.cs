string connectionString = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=" + \n                             csvFilePath + ";Extended Properties=\"Text;HDR=Yes;FMT=Delimited\"";\n   using (OleDbConnection connection = new OleDbConnection(connectionString))\n   {\n       OleDbCommand command = new OleDbCommand("SELECT * FROM [filename.csv]", connection);\n       OleDbDataAdapter adapter = new OleDbDataAdapter(command);\n       DataSet dataSet = new DataSet();\n       adapter.Fill(dataSet);\n   }