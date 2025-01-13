# Set variables\n$sourceSafePath = "C:\Path\To\SourceSafe"\n$backupPath = "C:\Path\To\Backup\SourceSafeBackup.zip"\n$remoteServer = "sftp://remote.server.com"\n$remotePath = "/path/to/backup/"\n$username = "yourUsername"\n$password = "yourPassword"\n\n# Create a backup using SourceSafe command-line\n& "C:\Path\To\SourceSafe\ss.exe" Backup $sourceSafePath -O $backupPath\n\n# Compress the backup file\nCompress-Archive -Path $sourceSafePath -DestinationPath $backupPath\n\n# Encrypt the backup file\n$securePassword = ConvertTo-SecureString $password -AsPlainText -Force\n$credential = New-Object System.Management.Automation.PSCredential ($username, $securePassword)\n$encryptedBackupPath = "$backupPath.enc"\nopenssl enc -aes-256-cbc -salt -in $backupPath -out $encryptedBackupPath -k $password\n\n# Securely transfer the backup file\n$session = New-SFTPSession -ComputerName $remoteServer -Credential $credential\nSet-SFTPFile -SessionId $session.SessionId -LocalFile $encryptedBackupPath -RemotePath $remotePath\nRemove-SFTPSession -SessionId $session.SessionId\n\n# Send email notification\n$emailTo = "admin@example.com"\n$emailSubject = "SourceSafe Backup Completed"\n$emailBody = "The backup of the SourceSafe database has been completed and transferred."\nSend-MailMessage -To $emailTo -Subject $emailSubject -Body $emailBody -SmtpServer "smtp.example.com"