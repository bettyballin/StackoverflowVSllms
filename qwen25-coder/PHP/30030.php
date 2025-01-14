// Define your database configuration\n$dbConfig = [\n    'type' => 'mysql', // or 'pgsql', 'sqlite', etc.\n    'host' => 'localhost',\n    'dbname' => 'your_database',\n    'username' => 'your_username',\n    'password' => 'your_password',\n];\n\ntry {\n    $dsn = "{$dbConfig['type']}:host={$dbConfig['host']};dbname={$dbConfig['dbname']}";\n    $pdo = new PDO($dsn, $dbConfig['username'], $dbConfig['password']);\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n} catch (PDOException $e) {\n    echo "Connection failed: " . $e->getMessage();\n}\n\n// Use the $pdo object for database operations\n$stmt = $pdo->prepare("SELECT * FROM your_table");\n$stmt->execute();\n\n$results = $stmt->fetchAll(PDO::FETCH_ASSOC);