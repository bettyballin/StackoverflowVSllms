SELECT Name, Street, City, State\nFROM (\n  SELECT Name, Street, City, State,\n    ROW_NUMBER() OVER (PARTITION BY Name ORDER BY Street) AS RowNum\n  FROM Addresses\n) AS T\nWHERE RowNum = 1