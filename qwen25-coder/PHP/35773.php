<?php\n// Assume $dbConnection is your PDO object\n$stmt = $dbConnection->query("SELECT value FROM settings WHERE name='maintenance_mode'");\n$maintenanceMode = (bool) $stmt->fetchColumn();\n\nif ($maintenanceMode && basename($_SERVER['PHP_SELF']) !== 'maintenance.php') {\n    header('HTTP/1.1 503 Service Temporarily Unavailable');\n    header('Status: 503 Service Temporarily Unavailable');\n    header('Retry-After: 3600'); // In seconds, how long until they can try again\n    exit(header("Location: /maintenance.php"));\n}\n?>