BACKUP DATABASE [YourDatabaseName]\n   TO DISK = 'C:\Backups\YourDatabaseName.bak'\n   WITH FILEGROUP = 'PRIMARY',\n        FILEGROUP = 'YourOnlineFG';