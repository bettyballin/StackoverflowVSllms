using System;\nusing System.Data;\n\npublic void CreateSubDataSet(DataSet originalDataSet)\n{\n    // Ensure the original DataSet has at least one DataTable\n    if (originalDataSet == null || originalDataSet.Tables.Count == 0) return;\n\n    // Assume you want to split the first table in the data set into two tables with different columns.\n    DataTable originalTable = originalDataSet.Tables[0];\n    \n    // Create a new DataSet for subsets\n    DataSet subDataSet = new DataSet();\n\n    // Define columns for Table1 (columns 0-13)\n    DataTable table1 = originalTable.Clone();\n    table1.Columns.RemoveAt(14); // Remove all columns from index 14 onwards\n    foreach (DataRow row in originalTable.Rows)\n    {\n        DataRow newRow = table1.NewRow();\n        for (int i = 0; i < 14; i++)\n        {\n            newRow[i] = row[i];\n        }\n        table1.Rows.Add(newRow);\n    }\n\n    // Define columns for Table2 (columns 14-27)\n    DataTable table2 = originalTable.Clone();\n    for (int i = 13; i >= 0; i--)\n    {\n        table2.Columns.RemoveAt(i); // Remove all columns from index 0 to 13\n    }\n    foreach (DataRow row in originalTable.Rows)\n    {\n        DataRow newRow = table2.NewRow();\n        for (int i = 14; i < 28; i++)\n        {\n            newRow[i - 14] = row[i];\n        }\n        table2.Rows.Add(newRow);\n    }\n\n    // Add tables to the new DataSet\n    subDataSet.Tables.Add(table1);\n    subDataSet.Tables.Add(table2);\n\n    // Use the subDataSet as needed\n    Console.WriteLine("Table 1: " + subDataSet.Tables[0].Rows.Count + " rows.");\n    Console.WriteLine("Table 2: " + subDataSet.Tables[1].Rows.Count + " rows.");\n}