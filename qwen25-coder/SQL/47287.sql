-- Weekly Full Backups (e.g., Sunday)\nBACKUP DATABASE YourDatabaseName TO DISK = '\\YourFTPPath\WeeklyBackup.bak' WITH COMPRESSION;\n\n-- Nightly Differential Backups (e.g., every night except Sundays)\nBACKUP DATABASE YourDatabaseName TO DISK = '\\YourFTPPath\DifferentialBackup.bak' WITH DIFFERENTIAL, COMPRESSION;\n\n-- Optional: Transaction Log Backups if needed\nBACKUP LOG YourDatabaseName TO DISK = '\\YourFTPPath\LogBackup.trn';