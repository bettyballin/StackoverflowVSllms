DECLARE @BackupPath NVARCHAR(256)\nDECLARE @DatabaseName NVARCHAR(128)\nDECLARE @CurrentDate NVARCHAR(30)\n\n-- Set your database name\nSET @DatabaseName = N'Northwind'\n\n-- Get the current date in a format suitable for filenames (e.g., yyyy-m-d)\nSET @CurrentDate = FORMAT(GETDATE(), 'yyyy-MM-dd')\n\n-- Construct the full backup path\nSET @BackupPath = N'C:\Backups\' + @DatabaseName + '_' + @CurrentDate + '.bak'\n\n-- Perform the backup to the dynamic filename\nBACKUP DATABASE @DatabaseName TO DISK = @BackupPath WITH INIT, COMPRESSION, NAME = N'Full Backup of ' + @DatabaseName