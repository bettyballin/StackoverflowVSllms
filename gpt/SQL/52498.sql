-- Restore the old table from a backup file\nRESTORE DATABASE [YourDatabase] \nFROM DISK = N'C:\Backup\YourTable_MonthYear.bak' \nWITH FILE = 1, \nMOVE 'YourTable_LogicalName' TO 'C:\Database\YourTable_PhysicalName.mdf', \nMOVE 'YourTable_Log_LogicalName' TO 'C:\Database\YourTable_Log.ldf', \nNOUNLOAD, STATS = 10;