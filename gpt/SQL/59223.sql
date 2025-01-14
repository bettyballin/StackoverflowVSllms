USE [YourDatabaseName];\nGO\n-- Backup the log file before shrinking\nBACKUP LOG [YourDatabaseName] TO DISK = 'C:\Backup\YourDatabaseName_LogBackup.trn';\nGO\n-- Shrink the log file\nDBCC SHRINKFILE (N'YourDatabaseName_Log' , 1);\nGO