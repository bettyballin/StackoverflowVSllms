SELECT column_name, data_type, nullable \nFROM all_tab_columns@<database> \nWHERE table_name = '<TABLE>';