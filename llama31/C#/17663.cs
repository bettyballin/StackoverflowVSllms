private void copy(DataRow rowFrom, DataRow rowTo)\n{\n    foreach (DataColumn c in rowFrom.Table.Columns) \n    {\n        rowTo[c.ColumnName] = rowFrom[c.ColumnName];\n    }\n}