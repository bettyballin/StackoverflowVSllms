-- Set up a primary database for log shipping\nDECLARE @BackupJobId AS UNIQUEIDENTIFIER;\nEXEC msdb.dbo.sp_add_log_shipping_primary_database \n    @database = N'YourDatabase',\n    @backup_directory = N'C:\LogShipping\Backups',\n    @backup_share = N'\\networkpath\LogShipping\Backups',\n    @backup_job_name = N'LSBackup_YourDatabase_Job',\n    @backup_retention_period = 48,\n    @backup_compression = 2,\n    @backup_threshold = 60,\n    @threshold_alert_enabled = 1,\n    @history_retention_period = 5760,\n    @job_id = @BackupJobId OUTPUT;\nGO\n\n-- Set up a secondary database for log shipping\nEXEC msdb.dbo.sp_add_log_shipping_secondary_database \n    @secondary_database = N'YourDatabase',\n    @primary_server = N'PrimaryServerName',\n    @primary_database = N'YourDatabase',\n    @restore_directory = N'C:\LogShipping\Restores',\n    @file_retention_period = 48,\n    @load_job_name = N'LSRestore_YourDatabase_Job',\n    @use_stANDBY = 1; -- Set to standby mode\nGO