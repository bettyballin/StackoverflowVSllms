USE [master];\nGO\n\nBACKUP DATABASE [YourDatabaseName]\nTO DISK = 'C:\Backups\YourDatabaseName.bak'\nWITH NOFORMAT, NOINIT, NAME = 'YourDatabaseName-Full Database Backup', SKIP, NOREWIND, NOUNLOAD, STATS = 10;\nGO