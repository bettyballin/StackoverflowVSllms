SELECT column_name, data_type\nFROM all_tab_columns\nWHERE table_name = 'STUDENTS'\n  AND owner = 'BOB';