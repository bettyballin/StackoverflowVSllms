-- Original query with ANSI-99 join syntax\nEXPLAIN PLAN FOR\nSELECT *\nFROM table1\nINNER JOIN table2 ON table1.column = table2.column;\n\n-- Rewritten query with predicate pushing\nEXPLAIN PLAN FOR\nSELECT *\nFROM table1, table2\nWHERE table1.column = table2.column;