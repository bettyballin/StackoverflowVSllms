RESTORE DATABASE YourDatabaseName\n   FROM DISK = 'C:\Path\To\BackupFile.bak'\n   WITH MOVE 'LogicalDataFileName' TO 'C:\Path\On\YourServer\PhysicalDataFileName.mdf',\n        MOVE 'LogicalLogFileName' TO 'C:\Path\On\YourServer\PhysicalLogFile.ldf';