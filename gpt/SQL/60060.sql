WITH RankedEntries AS (\n    SELECT\n        id,\n        user_id,\n        created,\n        ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY created DESC) AS row_num\n    FROM entries\n)\nUPDATE entries\nSET processed = true\nFROM RankedEntries\nWHERE entries.id = RankedEntries.id\nAND RankedEntries.row_num > 3;