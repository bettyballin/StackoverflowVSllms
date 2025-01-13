SELECT \n    i.name AS IndexName,\n    SUM(s.used_page_count * 8) AS IndexSizeKB\nFROM \n    sys.dm_db_partition_stats AS s\nJOIN \n    sys.indexes AS i ON s.object_id = i.object_id AND s.index_id = i.index_id\nWHERE \n    i.name = 'IX_MY_INDEX'\nGROUP BY \n    i.name;