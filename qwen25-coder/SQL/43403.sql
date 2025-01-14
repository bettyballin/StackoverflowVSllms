USE YourDatabase;\nGO\n\n-- Enable the database for Change Data Capture\nEXEC sys.sp_cdc_enable_db;\nGO\n\n-- Enable change data capture on a specific table\nEXEC sys.sp_cdc_enable_table \n    @source_schema = N'dbo',  \n    @source_name   = N'YourTable',\n    @role_name     = NULL; -- Optional: Create a role for access to the CDC features and change tables\nGO