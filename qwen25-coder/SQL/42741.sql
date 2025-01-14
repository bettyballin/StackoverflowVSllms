MERGE INTO KeyMap km\nUSING (\n    SELECT \n        TRUNC(s.ID / 100) AS batchID,\n        MAX(CASE WHEN s.ID MOD 100 = 0 THEN s.KEY END) AS key1,\n        MAX(CASE WHEN s.ID MOD 100 = 1 THEN s.KEY END) AS key2,\n        MAX(CASE WHEN s.ID MOD 100 = 2 THEN s.KEY END) AS key3,\n        -- Continue this pattern up to key99\n        MAX(CASE WHEN s.ID MOD 100 = 98 THEN s.KEY END) AS key99\n    FROM Source s\n    GROUP BY TRUNC(s.ID / 100)\n) src_melting ON (km.batchID = src_melting.batchID)\nWHEN MATCHED THEN\n    UPDATE SET \n        km.key1 = src_melting.key1,\n        km.key2 = src_melting.key2,\n        km.key3 = src_melting.key3,\n        -- Continue setting keys up to key99\n        km.key99 = src_melting.key99;