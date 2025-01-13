SELECT t1.Name, t1.Candy, t1.PreferenceFactor\nFROM YourTable t1\nWHERE t1.PreferenceFactor = (\n  SELECT TOP 1 PreferenceFactor\n  FROM YourTable t2\n  WHERE t2.Name = t1.Name\n  ORDER BY PreferenceFactor DESC\n)