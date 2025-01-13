WITH OrderedEntries AS (\n    SELECT\n        timefield,\n        ROW_NUMBER() OVER (ORDER BY timefield) AS row_num\n    FROM\n        entries\n    WHERE\n        uid = ?\n)\nSELECT\n    timefield\nFROM\n    OrderedEntries\nWHERE\n    row_num % 150 = 1;