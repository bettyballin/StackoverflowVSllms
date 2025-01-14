-- Find recommended missing indexes\n   SELECT \n       migs.avg_total_user_cost * (migs.avg_user_impact / 100.0) * (migs.user_seeks + migs.user_scans) AS improvement_measure,\n       'CREATE INDEX [missing_index_' + CONVERT(VARCHAR(128), mig.index_group_handle)\n        + '_' + CONVERT(VARCHAR(128), mid.index_handle) + '_' + OBJECT_NAME(ind.object_id, ind.database_id) + ']'\n        + ' ON ' + OBJECT_NAME(ind.object_id, ind.database_id) \n        + ' (' + ISNULL(mid.equality_columns,'') \n        + CASE WHEN mid.equality_columns IS NOT NULL AND mid.inequality_columns IS NOT NULL THEN ',' ELSE '' END\n        + ISNULL (mid.inequality_columns, '')\n        + ')' \n        + ISNULL (' INCLUDE (' + mid.included_columns + ')', '') AS create_index_statement,\n       migs.*,\n       mid.database_id,\n       mid.[object_id]\n   FROM sys.dm_db_missing_index_groups mig WITH (NOLOCK)\n   INNER JOIN sys.dm_db_missing_index_group_stats migs WITH (NOLOCK) ON mig.index_group_handle = migs.group_handle\n   INNER JOIN sys.dm_db_missing_index_details mid WITH (NOLOCK) ON mig.index_handle = mid.index_handle\n   INNER JOIN sys.indexes ind WITH (NOLOCK) ON mid.[object_id] = ind object_id\n   ORDER BY improvement_measure DESC;