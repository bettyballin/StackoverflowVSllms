UPDATE your_table_name\nSET column_name = REPLACE(column_name, CHR(13), '')\nWHERE INSTR(column_name, CHR(13)) > 0;