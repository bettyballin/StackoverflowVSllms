-- Full Backup Script\nBACKUP DATABASE YourDatabaseName TO DISK = 'C:\Backups\YourDatabaseName_Full.bak' WITH INIT, COMPRESSION;\n\n-- Differential Backup Script\nBACKUP DATABASE YourDatabaseName TO DISK = 'C:\Backups\YourDatabaseName_Diff.bak' WITH DIFFERENTIAL, INIT, COMPRESSION;