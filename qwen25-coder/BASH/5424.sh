# Backup command using Percona XtraBackup\nxtrabackup --backup --target-dir=/path/to/backup\n\n# Prepare (apply) the backup to make it consistent\nxtrabackup --prepare --target-dir=/path/to/backup\n\n# Restore from a backup directory to MySQL datadir\nsystemctl stop mysql\nxtrabackup --move-back --target-dir=/path/to/backup\nchown -R mysql:mysql /var/lib/mysql\nsystemctl start mysql