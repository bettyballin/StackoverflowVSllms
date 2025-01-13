WITH FIRST_DAY_PRECEDING_MONTH AS (\n    SELECT DATE(SUBSTR(CHAR(CURRENT DATE - 1 MONTH), 1, 7) || '-01') AS FIRST_DAY\n    FROM SYSIBM.SYSDUMMY1\n)\nSELECT *\nFROM YOUR_TABLE\nWHERE YOUR_DATE_COLUMN >= (SELECT FIRST_DAY FROM FIRST_DAY_PRECEDING_MONTH)\n  AND YOUR_DATE_COLUMN < (CURRENT DATE - (DAY(CURRENT DATE)-1) DAYS);