WITH RecursiveCTE AS (\n  SELECT Name, SlotValue, Slots, 1 AS Slot\n  FROM InputTable\n  UNION ALL\n  SELECT Name, 0 AS SlotValue, Slots, Slot + 1\n  FROM RecursiveCTE\n  WHERE Slot < Slots\n)\nSELECT \n  Name,\n  SUM(SlotValue) OVER (PARTITION BY Name ORDER BY Slot) AS SlotSum,\n  Slot\nFROM RecursiveCTE\nORDER BY Name, Slot;