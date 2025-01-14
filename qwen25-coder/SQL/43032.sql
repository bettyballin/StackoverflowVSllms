SELECT e.Id, e.Name,\n       COALESCE(h.NewValue, e.Department) AS Department\nFROM Employee e\nLEFT JOIN (\n    SELECT RowId, Field, NewValue, ChangeDate\n    FROM History h1\n    WHERE Field = 'Department'\n    AND ChangeDate < '2023-04-01' -- replace with your date of interest\n    AND NOT EXISTS (\n        SELECT 1\n        FROM History h2\n        WHERE h2.ChangeDate > h1.ChangeDate\n        AND h2.Field = h1.Field\n        AND h2.RowId = h1.RowId\n        AND h2.ChangeDate < '2023-04-01' -- replace with your date of interest\n    )\n) h ON e.Id = h.RowId;