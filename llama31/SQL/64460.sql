SELECT array_to_string(array_agg(DISTINCT field), ';') \nFROM your_table;