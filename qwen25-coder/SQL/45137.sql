-- Enable CDC on the database first if it's not already enabled\nUSE YourDatabaseName;\nGO\nEXEC sys.sp_cdc_enable_db;\nGO\n\n-- Then enable CDC for the specific table\nUSE YourDatabaseName;\nGO\nEXEC sys.sp_cdc_enable_table \n    @source_schema = N'dbo', \n    @source_name   = N'YourTableName', \n    @role_name     = NULL,\n    @filegroup_name = N'DFS_CDC';\nGO