SELECT \n    a,\n    (a * 2) AS b  -- this creates a virtual column 'b' which is twice the value of 'a'\nFROM \n    your_table;