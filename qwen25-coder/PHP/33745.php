// Assuming you have a PDO instance in `$pdo`\n$query = "SELECT setting_name, value FROM settings WHERE setting_name IN ('host', 'username', 'password', 'database')";\n$result = $pdo->query($query);\n\n$config = [];\nforeach ($result as $row) {\n    $config[$row['setting_name']] = $row['value'];\n}\n\necho $config['host']; // Outputs: 127.0.0.1