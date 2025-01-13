<?php\n// Database configuration\n$dbHost = 'localhost';\n$dbUsername = 'yourUsername';\n$dbPassword = 'yourPassword';\n$dbName = 'yourDatabaseName';\n\n// Path to save the backup file\n$backupFile = '/path/to/backup/' . $dbName . '_' . date("Y-m-d-H-i-s") . '.sql';\n\n// mysqldump command\n$command = "mysqldump --opt -h$dbHost -u$dbUsername -p$dbPassword $dbName > $backupFile";\n\n// Execute the command\nsystem($command, $output);\n\nif ($output === 0) {\n    echo "Backup successful.";\n} else {\n    echo "Backup failed.";\n}\n?>