SELECT * FROM DBA_FLASHBACK_ARCHIVE\nWHERE table_name = 'YOUR_TABLE_NAME';\n\nSELECT * FROM DBA_FLASHBACK_TRANSACTION\nWHERE table_name = 'YOUR_TABLE_NAME';