SELECT \n    OBJECT_NAME(IXUS.[object_id]) AS TableName,\n    MAX(IXUS.last_user_update) AS LastUserUpdate\nFROM \n    sys.dm_db_index_usage_stats AS IXUS\nWHERE \n    IXUS.database_id = DB_ID('YourDatabaseName')\nGROUP BY \n    OBJECT_NAME(IXUS.[object_id])\nORDER BY \n    LastUserUpdate DESC;