SELECT h1.*\nFROM History h1\nINNER JOIN (\n  SELECT Name, MAX(Timestamp) as MaxTimestamp\n  FROM History\n  GROUP BY Name\n) h2\nON h1.Name = h2.Name AND h1.Timestamp = h2.MaxTimestamp