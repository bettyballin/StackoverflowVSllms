SELECT a.* \nFROM TableA a \nWHERE \n    EXISTS (\n        SELECT 1 \n        FROM TableB b \n        WHERE b.id = a.id AND b.status IN (1, 6)\n    )\n    AND NOT EXISTS (\n        SELECT 1 \n        FROM TableB b \n        WHERE b.id = a.id AND (b.status IS NULL OR b.status IN (2, 7))\n    )