SELECT \n    column1 AS ColumnName1,\n    column2 AS ColumnName2,\n    ...\n    columnN AS ColumnNameN\nFROM \n    (VALUES (NULL)) AS t(column1, column2, ..., columnN)\nWHERE 1=0;