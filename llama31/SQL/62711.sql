UPDATE A\nSET A.Sector = B.Sector\nFROM tbFoo A\nINNER JOIN (\n  SELECT SectorKey, Sector\n  FROM tbFoo\n  WHERE Sector IS NOT NULL\n) B\nON A.SectorKey = B.SectorKey\nWHERE A.Sector IS NULL;