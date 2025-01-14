WITH RankedEntries AS (\n    SELECT \n        id, \n        category, \n        insertdate, \n        title,\n        ROW_NUMBER() OVER (PARTITION BY category ORDER BY insertdate DESC) as rn\n    FROM \n        your_table_name\n)\nSELECT \n    id, \n    category, \n    insertdate, \n    title\nFROM \n    RankedEntries\nWHERE \n    rn <= 2\nORDER BY \n    category, \n    insertdate DESC;