-- Example of creating partitions (syntax varies by database)\n   CREATE TABLE people (\n     id       INTEGER PRIMARY KEY,\n     name     VARCHAR(100),\n     status   VARCHAR(20)\n   ) PARTITION BY LIST (status);\n\n   CREATE TABLE people_active PARTITION OF people FOR VALUES IN ('active');\n   CREATE TABLE people_inactive PARTITION OF people FOR VALUES IN ('inactive');