# Import SQL Server module\nImport-Module SqlServer\n\n# Define connection parameters\n$primaryServer = "your_primary_server_name"\n$secondaryServer = "your_secondary_server_name"\n$databaseName = "your_database_name"\n\n# Define email parameters\n$smtpServer = "your_smtp_server_name"\n$fromAddress = "your_from_email_address"\n$toAddress = "your_to_email_address"\n\n# Query primary server\n$primaryQuery = "SELECT @@SERVERNAME AS ServerName, CASE WHEN server_id = 1 THEN 'PRIMARY' ELSE 'SECONDARY' END AS Role FROM sys.servers WHERE server_id = 1;"\n$primaryResult = Invoke-SqlCmd -ServerInstance $primaryServer -Database $databaseName -Query $primaryQuery\n\n# Query secondary server\n$secondaryQuery = "SELECT @@SERVERNAME AS ServerName, CASE WHEN server_id = 1 THEN 'PRIMARY' ELSE 'SECONDARY' END AS Role FROM sys.servers WHERE server_id = 1;"\n$secondaryResult = Invoke-SqlCmd -ServerInstance $secondaryServer -Database $databaseName -Query $secondaryQuery\n\n# Check if primary server has changed\nif ($primaryResult.Role -ne "PRIMARY") {\n    # Send email notification\n    $subject = "SQL Server Failover: Primary Server Changed"\n    $body = "The primary server has changed to $($secondaryResult.ServerName)."\n    Send-MailMessage -SmtpServer $smtpServer -From $fromAddress -To $toAddress -Subject $subject -Body $body\n}