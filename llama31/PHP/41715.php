$dsn = 'mysql:host=localhost;dbname=example';\n$username = 'username';\n$password = 'password';\n\ntry {\n    $pdo = new PDO($dsn, $username, $password);\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    $sql = '\n        SELECT * FROM users WHERE id = 1;\n        SELECT * FROM orders WHERE user_id = 1;\n    ';\n\n    $stmt = $pdo->prepare($sql);\n    $stmt->execute();\n\n    // Fetch results from the first query\n    $users = $stmt->fetchAll(PDO::FETCH_ASSOC);\n\n    // Fetch results from the second query\n    $stmt->nextRowset();\n    $orders = $stmt->fetchAll(PDO::FETCH_ASSOC);\n\n    // Display the results\n    print_r($users);\n    print_r($orders);\n} catch (PDOException $e) {\n    echo 'Error: ' . $e->getMessage();\n}