mysqldump -u [username] -p[password] [database_name] > backup.sql\nscp backup.sql user@localhost:/path/to/backup/folder