SELECT * \nFROM table_1 t1 \nWHERE t1.c1 IS NOT NULL \n  AND trim(t1.c1) IS NOT NULL \n  AND trim(t1.c1) != '';