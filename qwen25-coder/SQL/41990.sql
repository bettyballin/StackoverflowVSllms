SELECT t.col1, MAX(t.col2) AS col2\nFROM your_table_name t\nGROUP BY t.col1;