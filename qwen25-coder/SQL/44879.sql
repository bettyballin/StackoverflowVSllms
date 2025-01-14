-- Assuming table1 and table2 are structured as you described,\n-- and you want to insert rows with specific values ('a', 'a', ..., fk)\n\nINSERT INTO Table1 (column1, column2, column3, column4, column5, foreignKey)\nSELECT \n    'a' AS column1,\n    'a' AS column2,\n    'a' AS column3,\n    'a' AS column4,\n    'a' AS column5,\n    t2.id AS foreignKey\nFROM Table2 t2;