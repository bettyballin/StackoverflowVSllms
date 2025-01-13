SELECT i.ItemID\nFROM Item i\nWHERE EXISTS (\n  SELECT 1\n  FROM ItemCategory ic\n  WHERE ic.ItemID = i.ItemID\n  AND ic.CategoryID IN (01, 02)\n)\nAND NOT EXISTS (\n  SELECT 1\n  FROM ItemCategory ic\n  WHERE ic.ItemID = i.ItemID\n  AND ic.CategoryID IN (12)\n)