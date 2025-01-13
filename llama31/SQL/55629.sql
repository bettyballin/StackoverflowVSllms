SELECT t1.Name, t1.Candy, t1.PreferenceFactor\nFROM (\n  SELECT Name, Candy, PreferenceFactor,\n    ROW_NUMBER() OVER (PARTITION BY Name ORDER BY PreferenceFactor DESC) AS RowNum\n  FROM YourTable\n) t1\nWHERE t1.RowNum = 1