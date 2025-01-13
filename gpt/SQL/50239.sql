SELECT some_field\n    FROM (\n        SELECT DISTINCT some_field\n        FROM some_table\n        WHERE some_field LIKE 'text%'\n    ) AS distinct_results\n    LIMIT 10;