SELECT table_name, num_rows\nFROM user_tables\nWHERE num_rows = (SELECT MAX(num_rows) FROM user_tables);