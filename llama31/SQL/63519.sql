SELECT \n  a AS b,  -- creates a virtual column 'b' with the value of column 'a'\n  some_expression AS virtual_column  -- creates a virtual column with the result of the expression\nFROM \n  your_table;