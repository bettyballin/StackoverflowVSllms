$driver = $pdo->getAttribute(PDO::ATTR_DRIVER_NAME);\necho "Using PDO Driver: $driver\n";\n\n$stmt = $pdo->query('SELECT id, name FROM products');\nforeach (range(0, 1) as $columnIndex) {\n    $meta = $stmt->getColumnMeta($columnIndex);\n    echo "Column Index: $columnIndex, Native Type: {$meta['native_type']}\n";\n}