string[] columnNamesToRemove = {"ColumnName2", "ColumnName1"};\n\nforeach (var columnName in columnNamesToRemove)\n{\n    if (rh.dsDetail.Tables[0].Columns.Contains(columnName))\n    {\n        rh.dsDetail.Tables[0].Columns.Remove(columnName);\n    }\n}