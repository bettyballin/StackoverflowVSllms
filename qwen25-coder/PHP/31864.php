<?php\n$dsn = 'mysql:host=localhost;dbname=your_database;charset=utf8';\n$username = 'username';\n$password = 'password';\n\ntry {\n    $pdo = new PDO($dsn, $username, $password);\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    $sql = "SELECT QNO FROM TABLE ORDER BY RAND() LIMIT 10";\n    $stmt = $pdo->query($sql);\n\n    $columnArray = [];\n    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n        $columnArray[] = $row['QNO'];\n    }\n\n} catch (PDOException $e) {\n    echo "Connection failed: " . $e->getMessage();\n}\n\n// Now $columnArray contains your QNO values\nprint_r($columnArray);\n?>