SELECT table_name \nFROM information_schema.tables \nWHERE table_schema = 'your_schema' \nAND table_name = 'your_table_name';