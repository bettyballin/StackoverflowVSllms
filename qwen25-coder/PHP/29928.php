// Example snippet to demonstrate SQLite native types using PDO\n$stmt = $pdo->query('SELECT price, name FROM products');\n$meta = $stmt->getColumnMeta(0);\necho "SQLite Price column type: {$meta['native_type']}\n"; // Likely 'real'