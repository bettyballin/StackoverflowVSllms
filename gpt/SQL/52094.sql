SELECT SUM(activity_amount)\nFROM (\n    SELECT MIN(derived_value, activity) AS activity_amount\n    FROM activities\n    JOIN (\n        SELECT name_id, SUM(points) - 20 AS derived_value\n        FROM foods\n        WHERE name_id IN (SELECT pk FROM dates WHERE weekly = 1)\n        GROUP BY name_id\n        HAVING SUM(points) > 20\n    ) AS derived_table\n    ON activities.activity_id = derived_table.name_id\n);