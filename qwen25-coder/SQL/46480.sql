-- Enable CDC on the database\nUSE YourWarehouseDB;\nGO\n\nEXEC sys.sp_cdc_enable_db;\nGO\n\n-- Enable CDC on a specific table\nUSE YourWarehouseDB;\nGO\n\nEXEC sys.sp_cdc_enable_table\n@source_schema = N'dbo',\n@source_name   = N'YourTable',\n@role_name     = NULL,\n@filegroup_name = NULL,\n@index_name    = NULL,\n@captured_column_list = NULL,\n@supports_net_changes = 0;\nGO