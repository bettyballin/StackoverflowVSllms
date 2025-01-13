# Import the SMO namespace\nImport-Module Microsoft.SqlServer.Management.Smo\n\n# Define the backup files and database names\n$weeklyFullBackupFile = 'C:\Backup\WeeklyFullBackup.bak'\n$dailyIncrementalBackupFile = 'C:\Backup\DailyIncrementalBackup.bak'\n$transactionLogBackupFile = 'C:\Backup\TransactionLogBackup.trn'\n$reportingDatabaseName = 'ReportingDB'\n\n# Create a new SMO server object\n$server = New-Object Microsoft.SqlServer.Management.Smo.Server('ReportingDB_Server_Name')\n\n# Restore the weekly full backup with NORECOVERY\n$server.Databases[$reportingDatabaseName].Restore($weeklyFullBackupFile, [Microsoft.SqlServer.Management.Smo.RestoreActionType]::Database, [Microsoft.SqlServer.Management.Smo.RestoreSourceType]::Disk, $true)\n\n# Restore the daily incremental backup with NORECOVERY\n$server.Databases[$reportingDatabaseName].Restore($dailyIncrementalBackupFile, [Microsoft.SqlServer.Management.Smo.RestoreActionType]::Database, [Microsoft.SqlServer.Management.Smo.RestoreSourceType]::Disk, $true)\n\n# Restore the transaction log backup with RECOVERY\n$server.Databases[$reportingDatabaseName].Restore($transactionLogBackupFile, [Microsoft.SqlServer.Management.Smo.RestoreActionType]::Log, [Microsoft.SqlServer.Management.Smo.RestoreSourceType]::Disk, $false)