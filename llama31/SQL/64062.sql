SELECT CONVERT(INT, REPLACE(comment, 'activation successful of id ', ''))\nFROM your_table;