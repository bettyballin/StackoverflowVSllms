USE master;\nGO\n\nRESTORE DATABASE [YourDatabaseName]\nFROM DISK = 'C:\Path\To\Backup\YourDatabaseName.bak'\nWITH NORECOVERY;\n\nRESTORE LOG [YourDatabaseName]\nFROM DISK = 'C:\Path\To\Backup\YourDatabaseName.trn'\nWITH STOPAT = '2023-02-20 09:00:00',  -- adjust the date and time to your needs\nRECOVERY;\nGO