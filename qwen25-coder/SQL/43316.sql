SELECT population_type_desc, condition_type_desc FROM sys.dm_fulltext_population WHERE database_id = DB_ID() AND table_id = OBJECT_ID('YourTableName');