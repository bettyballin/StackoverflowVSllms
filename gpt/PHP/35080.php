$validTables = ['users', 'orders', 'products'];  // List of valid table names\n$table = 'users';  // Example user input\n\nif (in_array($table, $validTables)) {\n    $stmt = $dbh->prepare("SELECT * FROM {$table} WHERE 1");\n    $stmt->execute();\n    var_dump($stmt->fetchAll());\n} else {\n    throw new Exception('Invalid table name.');\n}