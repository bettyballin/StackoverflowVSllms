SELECT [key] AS someValue\nFROM table t\nWHERE NOT EXISTS (\n    SELECT 1\n    FROM CONTAINSTABLE(table, columnName, '"thisWord"')\n    WHERE [key] = t.[key]\n);