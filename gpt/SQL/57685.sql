USE msdb;\nGO\n\nSELECT \n    database_name,\n    backup_finish_date\nFROM \n    backupset\nWHERE \n    database_name = 'YourDatabaseName'\nORDER BY \n    backup_finish_date DESC;\nGO