-- Select the database you want to change the collation for\nUSE your_database_name;\n\n-- Change the database collation\nALTER DATABASE your_database_name CHARACTER SET utf8 COLLATE utf8_bin;\n\n-- Loop through all tables and change each table's collation\nSET @tables = NULL;\nSET SESSION group_concat_max_len = 1000000;\n\nSELECT GROUP_CONCAT('ALTER TABLE ', table_name, ' CONVERT TO CHARACTER SET utf8 COLLATE utf8_bin;') INTO @tables\nFROM information_schema.tables \nWHERE table_schema = 'your_database_name';\n\nPREPARE stmt FROM @tables;\nEXECUTE stmt;\nDEALLOCATE PREPARE stmt;\n\n-- Loop through all tables and change each column's collation\nSET @columns = NULL;\n\nSELECT GROUP_CONCAT('ALTER TABLE ', table_name, ' MODIFY ', column_name, ' ', column_type, ' CHARACTER SET utf8 COLLATE utf8_bin;') INTO @columns\nFROM information_schema.columns \nWHERE table_schema = 'your_database_name'\nAND COLLATION_NAME IS NOT NULL;\n\nPREPARE stmt FROM @columns;\nEXECUTE stmt;\nDEALLOCATE PREPARE stmt;