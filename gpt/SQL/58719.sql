SELECT column_name\nFROM your_table\nWHERE some_condition\nUNION ALL\nSELECT 'default_value'\nWHERE NOT EXISTS (SELECT 1 FROM your_table WHERE some_condition);