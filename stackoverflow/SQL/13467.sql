INSERT INTO MyTable COL1, COL2, ... , COLN\nSELECT ...cols and manipulations...\nFROM TABLE_1 t1\nINNER JOIN TABLE_2 t2 on t1.key = t2.foreignKey\nINNER JOIN TABLE_3 t3 on t2.key = t3.foreignKey