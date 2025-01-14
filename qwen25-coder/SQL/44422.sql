SELECT OBJECT_NAME(OBJECT_ID) AS Table Name,\n       i.name AS IndexName, \n       avg_fragmentation_in_percent\nFROM sys.dm_db_index_physical_stats(DB_ID(), NULL, NULL, NULL , 'LIMITED') ps\nINNER JOIN sys.indexes i ON ps.OBJECT_ID = i.OBJECT_ID AND ps.index_id = i.index_id\nWHERE OBJECT_NAME(OBJECT_ID) = 'userAccountInfo';