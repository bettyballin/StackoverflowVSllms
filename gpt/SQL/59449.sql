EXEC DBMS_STATS.SET_TABLE_PREFS('schema_name', 'table_name', 'INCREMENTAL', 'TRUE');\n   EXEC DBMS_STATS.GATHER_TABLE_STATS('schema_name', 'table_name', cascade => TRUE);