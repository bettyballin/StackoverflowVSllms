<?php\n$dsn = 'mysql:host=your_host;dbname=your_db';\n$username = 'your_username';\n$password = 'your_password';\n\ntry {\n    $pdo = new PDO($dsn, $username, $password);\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    $sql = "\n    (SELECT * FROM table1 WHERE id = :id_a)\n    UNION\n    (SELECT * FROM table1 WHERE id = :id_b AND NOT EXISTS (SELECT 1 FROM table1 WHERE id = :id_a))\n    LIMIT 1";\n    \n    $stmt = $pdo->prepare($sql);\n    $stmt->execute(['id_a' => 'a', 'id_b' => 'b']);\n    $result = $stmt->fetch(PDO::FETCH_ASSOC);\n\n    if ($result) {\n        print_r($result);\n    } else {\n        echo "No rows found.";\n    }\n\n} catch (PDOException $e) {\n    echo 'Connection failed: ' . $e->getMessage();\n}\n?>