EXPLAIN PLAN FOR\nSELECT *\nFROM your_table x\nWHERE \n  d.attribute3 = 'abcd*'  \n  AND x.STATUS != 'P' \n  AND x.STATUS != 'J' \n  AND x.STATUS != 'X' \n  AND x.STATUS != 'S' \n  AND x.STATUS != 'D' \n  AND CURRENT_TIMESTAMP - 1 < x.CREATION_TIMESTAMP;\n\nSELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);