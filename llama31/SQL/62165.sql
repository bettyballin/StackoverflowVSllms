SELECT *\nFROM (\n  SELECT SUBSTRING(Column1, 1, 4) + SUBSTRING(Column1, 4, 3)  AS Col1\n  FROM MyTable\n) AS MySubquery\nWHERE Col1 = 'MySearch'