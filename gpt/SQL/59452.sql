SELECT *\nFROM your_table\nWHERE your_timestamp_column = STR_TO_DATE('$dateString', '%Y-%d-%m');