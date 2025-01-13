try {\n    $dsn = 'sqlsrv:server=your_server;Database=your_dbname';\n    $username = 'your_username';\n    $password = 'your_password';\n    $options = [\n        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,\n        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,\n        PDO::ATTR_EMULATE_PREPARES   => false,\n    ];\n    \n    $pdo = new PDO($dsn, $username, $password, $options);\n} catch (PDOException $e) {\n    echo 'Connection failed: ' . $e->getMessage();\n}