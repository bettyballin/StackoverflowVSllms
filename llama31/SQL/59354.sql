SELECT /*+ USE_HASH(t1 t2) */ *\nFROM table1 t1\nJOIN table2 t2\nON t1.join_key = t2.join_key;