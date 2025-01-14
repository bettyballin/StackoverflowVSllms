<?php\n$dsn = 'mysql:host=host;dbname=dbname';\n$username = 'username';\n$password = 'password';\n\ntry {\n    $pdo = new PDO($dsn, $username, $password);\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    $stmt = $pdo->query('SELECT * FROM your_table_name');\n\n    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n        my_function($row['column_name']);\n    }\n} catch (PDOException $e) {\n    echo 'Connection failed: ' . $e->getMessage();\n}\n?>