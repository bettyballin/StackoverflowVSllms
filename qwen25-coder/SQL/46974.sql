SELECT DRVTBL.column_name\nFROM (\n    SELECT column1 AS column_name\n    FROM your_table\n) DRVTBL