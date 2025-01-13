SELECT\n    t1.end_block + 1 AS missing_start_block,\n    t2.start_block - 1 AS missing_end_block\nFROM\n    your_table t1\nJOIN\n    your_table t2 ON t1.end_block + 1 < t2.start_block\nWHERE\n    NOT EXISTS (\n        SELECT 1\n        FROM your_table t3\n        WHERE t3.start_block = t1.end_block + 1\n    )\nORDER BY\n    t1.id;