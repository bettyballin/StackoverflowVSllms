UPDATE YourTableName\nSET ColumnName = REPLACE(ColumnName COLLATE Latin1_General_BIN, 'searchString', 'replaceString')\nWHERE ColumnName COLLATE Latin1_General_BIN LIKE '%searchString%';