try\n{\n    MyDataSet dataSet = new MyDataSet();\n    DataRow row = dataSet.Tables["Table1"].NewRow();\n    row["ID"] = 1;\n    row["Name"] = ""; // This will trigger validation error\n    dataSet.Tables["Table1"].Rows.Add(row);\n    dataSet.AcceptChanges(); // This line throws the exception if validation fails\n}\ncatch (DataException ex)\n{\n    Console.WriteLine($"Validation Error: {ex.Message}");\n}