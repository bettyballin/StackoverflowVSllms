SELECT \n    table_name,\n    table_rows\nFROM \n    information_schema.tables\nWHERE \n    table_schema = 'your_database_name';