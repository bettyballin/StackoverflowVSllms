SELECT SUM(amount)\nFROM (\n  SELECT TOP 15 amount\n  FROM Sales\n  ORDER BY [Date] DESC\n) AS subquery