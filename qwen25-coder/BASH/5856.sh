# First, create a full backup using mysqldump with the --master-data flag\nmysqldump --single-transaction --flush-logs --master-data=2 --all-databases > full_backup.sql\n\n# Then, on subsequent days, use mysqlbinlog to extract changes since last backup:\nmysqlbinlog /path/to/mysql-bin.000* > incremental_changes_dayX.sql