SELECT NVL(column1, NVL(column2, NVL(column3, 'Default Value'))) AS result\nFROM your_table;