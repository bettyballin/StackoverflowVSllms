SELECT * \nFROM table1,table2 \nWHERE table2.start <= table1.end \nAND (table2.end IS NULL OR table2.end >= table1.start)