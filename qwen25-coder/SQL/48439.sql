SELECT name AS DatabaseName,\n       crdate AS CreationDate\nFROM sysdatabases\nWHERE name = 'YourDatabaseName'\n\n-- Check for database activity in the current SQL Server error log:\nEXEC xp_readerrorlog 0, 1, 'YourDatabaseName'