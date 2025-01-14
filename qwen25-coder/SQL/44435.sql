WITH SplitTables AS (\n    SELECT REGEXP_SUBSTR(TABLENAME, '[^,]+', 1, LEVEL) AS TableName\n    FROM MYTABLE\n    CONNECT BY INSTR(TABLENAME, ',', 1, LEVEL - 1) > 0\n           OR LEVEL = 1\n)\nSELECT *\nFROM SplitTables ST\nLEFT OUTER JOIN ALL_TAB_COLS ATC ON (UPPER(ST.TableName) = UPPER(ATC.Table_Name) AND ATC.Owner = 'ME')\nWHERE ATC.TABLE_NAME IS NULL;