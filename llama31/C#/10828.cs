// Assuming you have a DataSet named ds, and it contains two tables: "Table1" and "Table2",\n// and you have already established a DataRelation named "relation" between them.\n\n// Create a new DataRelation object (if it's not already created)\nDataRelation relation = new DataRelation("relation", ds.Tables["Table1"].Columns["ID"], ds.Tables["Table2"].Columns["ID"]);\n\n// Add the relation to the DataSet (if it's not already added)\nds.Relations.Add(relation);\n\n// Now, to get related rows from Table2 for a specific row in Table1\nforeach (DataRow row in ds.Tables["Table1"].Rows)\n{\n    // Use GetChildRows to get related rows from Table2\n    DataRow[] childRows = row.GetChildRows(relation);\n    \n    // Do something with the child rows\n    foreach (DataRow childRow in childRows)\n    {\n        // Process each child row here\n        Console.WriteLine(childRow["SomeColumnInTable2"]);\n    }\n}