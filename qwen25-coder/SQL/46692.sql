SELECT partname, pline, option\nFROM your_table_name\nWHERE NOT (pline = 10 AND option NOT IN ('option1', 'option2'))