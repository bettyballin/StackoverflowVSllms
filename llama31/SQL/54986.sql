BACKUP DATABASE [YourDatabaseName]\nTO DISK = 'C:\Backup\DifferentialBackup.bak'\nWITH DIFFERENTIAL, FORMAT, MEDIANAME = 'DifferentialBackupMedia', NAME = 'DifferentialBackup';