ALTER SESSION SET NLS_LANGUAGE = AMERICAN;\n   ALTER SESSION SET NLS_TERRITORY = AMERICA;\n   ALTER SESSION SET NLS_CHARACTERSET = AL32UTF8;\n\n   SPOOL output.csv\n\n   SELECT * FROM your_table;