DELETE FROM tRealtyTrac\nWHERE creation NOT IN (\n  SELECT TOP 3000 creation\n  FROM tRealtyTrac\n  ORDER BY creation DESC\n)