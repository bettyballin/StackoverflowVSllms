using System.Data;\n\n// Assuming 'originalDataSet' is your original DataSet with all data\n// and 'targetTableIndex' is the index of the table you want to filter\n\nDataTable clonedTable = originalDataSet.Tables[targetTableIndex].Clone();\n\n// Remove columns that are not needed.\nforeach (DataColumn column in originalDataSet.Tables[targetTableIndex].Columns)\n{\n    if (!columnsToExclude.Contains(column.ColumnName))  // Define 'columnsToExclude' array with column names to exclude\n    {\n        clonedTable.Columns.Add(column);\n    }\n}\n\n// Copy selected rows, only including the columns that weren't removed.\nforeach (DataRow row in originalDataSet.Tables[targetTableIndex].Rows)\n{\n    object[] items = new object[clonedTable.Columns.Count];\n    for (int i = 0; i < items.Length; i++)\n    {\n        items[i] = row[clonedTable.Columns[i]];\n    }\n\n    clonedTable.ImportRow(clonedTable.NewRow(items));\n}\n\n// Create a new DataSet to add the filtered DataTable\nDataSet filteredDataSet = new DataSet();\nfilteredDataSet.Tables.Add(clonedTable);\n\n// Now you can write this DataSet to XML\nfilteredDataSet.WriteXml("pathToOutput.xml");