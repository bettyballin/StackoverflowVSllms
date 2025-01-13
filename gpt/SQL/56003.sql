SELECT date,\n       item,\n       total\nFROM (\n    SELECT date,\n           item,\n           total,\n           ROW_NUMBER() OVER (PARTITION BY date ORDER BY total DESC, item) as row_num\n    FROM (\n        SELECT DATE(date) as date,\n               item,\n               COUNT(*) as total\n        FROM test_popularity\n        GROUP BY DATE(date), item\n    ) as item_totals\n) as ranked_items\nWHERE row_num = 1\nORDER BY date;