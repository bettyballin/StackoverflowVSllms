BEGIN\n  DBMS_STATS.GATHER_TABLE_STATS(ownname => NULL, tabname => 'YOUR_TABLE_NAME');\nEND;\n/