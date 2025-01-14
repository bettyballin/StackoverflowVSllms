SELECT \n    'TABLE_NAME1' AS Table_Name,\n    col.DATA_TYPE,\n    (SELECT TOP 1 col_name FROM TABLE_NAME1) AS Sample_Data\nFROM INFORMATION_SCHEMA.COLUMNS col\nWHERE col.TABLE_NAME = 'TABLE_NAME1'\n\nUNION ALL\n\nSELECT \n    'TABLE_NAME2' AS Table_Name,\n    col.DATA_TYPE,\n    (SELECT TOP 1 col_name FROM TABLE_NAME2) AS Sample_Data\nFROM INFORMATION_SCHEMA.COLUMNS col\nWHERE col.TABLE_NAME = 'TABLE_NAME2'\n\nUNION ALL\n\nSELECT \n    'TABLE_NAME3' AS Table_Name,\n    col.DATA_TYPE,\n    (SELECT TOP 1 col_name FROM TABLE_NAME3) AS Sample_Data\nFROM INFORMATION_SCHEMA.COLUMNS col\nWHERE col.TABLE_NAME = 'TABLE_NAME3';