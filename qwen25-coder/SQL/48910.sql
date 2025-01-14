SELECT CAST(SUM(p.rows) AS bigint)\n   FROM sys.partitions p\n   WHERE p.index_id IN (0, 1)\n     AND p.object_id = OBJECT_ID('YourTableName');