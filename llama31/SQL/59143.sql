DELETE t1\nFROM tRealtyTrac t1\nLEFT JOIN (\n  SELECT TOP 3000 creation\n  FROM tRealtyTrac\n  ORDER BY creation DESC\n) t2\nON t1.creation = t2.creation\nWHERE t2.creation IS NULL