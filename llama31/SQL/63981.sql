SELECT * FROM sys.dm_db_index_physical_stats(DB_ID(), OBJECT_ID('Department'), NULL, NULL, NULL);