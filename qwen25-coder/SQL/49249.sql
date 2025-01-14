WITH RankedVersions AS (\n    SELECT \n        ItemId, \n        ItemVersionId, \n        Year, \n        Value,\n        ROW_NUMBER() OVER (PARTITION BY ItemId, Year ORDER BY ItemVersionId DESC) as rn\n    FROM table t\n    WHERE ItemId = 1\n)\nSELECT ItemId, ItemVersionId, Year, Value\nFROM RankedVersions\nWHERE rn = 1;