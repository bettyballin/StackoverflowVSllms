SELECT column_name\nFROM information_schema.columns\nWHERE table_schema = 'public'\nAND table_name   = 'your_table_name';