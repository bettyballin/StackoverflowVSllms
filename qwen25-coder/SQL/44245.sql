-- This query might join two very large tables without proper indexing,\n-- leading to excessive processing time.\nSELECT *\nFROM table1 t1, table2 t2\nWHERE t1.common_field = t2.common_field;