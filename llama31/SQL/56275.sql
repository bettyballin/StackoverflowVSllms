SELECT a.*, b.Id, b.EntryTime\nFROM Customer a\nJOIN (\n  SELECT CustomerID, MAX(EntryTime) as LatestEntryTime\n  FROM Order\n  GROUP BY CustomerID\n) c ON a.Id = c.CustomerID\nJOIN Order b ON b.CustomerID = c.CustomerID AND b.EntryTime = c.LatestEntryTime