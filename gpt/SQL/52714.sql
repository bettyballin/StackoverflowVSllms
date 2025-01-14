SELECT t.*\n    FROM table t\n    JOIN (\n        SELECT 1 AS id\n        UNION ALL SELECT 2\n        UNION ALL SELECT 3\n        ...\n    ) AS temp ON t.x = temp.id;