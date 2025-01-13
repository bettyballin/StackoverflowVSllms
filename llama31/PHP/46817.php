$primaryKeyQuery = "SELECT COLUMN_NAME\n                   FROM information_schema.COLUMNS\n                   WHERE TABLE_SCHEMA = 'your_database_name'\n                     AND TABLE_NAME = 'your_table_name'\n                     AND COLUMN_KEY = 'PRI'";\n\n$primaryKeyResult = $mysqli->query($primaryKeyQuery);\n$primaryKeyColumn = $primaryKeyResult->fetch_assoc()['COLUMN_NAME'];\n\n$updateQuery = sprintf("UPDATE %s SET %s = %s WHERE %s = %s",\n                       'your_table_name',\n                       'your_column_name',\n                       'your_value',\n                       $primaryKeyColumn,\n                       'your_primary_key_value');