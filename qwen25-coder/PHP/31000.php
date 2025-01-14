<?php\n$backupFile = '/path/to/your/db-backup-file.sql';\n$dbHost = 'localhost';\n$dbName = 'your_database_name';\n$dbUser = 'postgres';\n\nexec("PGPASSWORD='your_password' pg_dump -h $dbHost -U $dbUser $dbName > " . escapeshellarg($backupFile), $output, $returnVar);\nif ($returnVar === 0) {\n    echo "Backup successful!";\n} else {\n    echo "Error during backup: " . implode("\n", $output);\n}\n?>