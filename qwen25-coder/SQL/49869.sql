BACKUP DATABASE [YourDatabaseName] \n     TO DISK = N'C:\Backups\YourDatabaseName.bak' \n     WITH NOFORMAT, INIT, NAME = N'YourDatabaseName-Full Database Backup', SKIP, NOREWIND, NOUNLOAD, STATS = 10