RESTORE DATABASE BugTrackerDB \n   FROM DISK = 'C:\Backups\BugTrackerDB.bak'\n   WITH MOVE 'BugTrackerDB_Data' TO 'C:\Data\BugTrackerDB.mdf',\n   MOVE 'BugTrackerDB_Log' TO 'C:\Data\BugTrackerDB_log.ldf'