SELECT i.ItemID\nFROM ItemCategory i\nWHERE i.CategoryID IN (01, 02)\nAND i.ItemID NOT IN (\n    SELECT i2.ItemID\n    FROM ItemCategory i2\n    WHERE i2.CategoryID = 12\n)\nGROUP BY i.ItemID\nHAVING COUNT(DISTINCT i.CategoryID) >= 2;