<?php\n$serverName = "localhost";\n$database = "dbname";\n$username = "username";\n$password = "password";\n\ntry {\n    $conn = new PDO("sqlsrv:server=$serverName;Database=$database", $username, $password);\n    // set the PDO error mode to exception\n    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    $sql = "\n        INSERT INTO table_name (column1, column2)\n        VALUES ('value1', 'value2');\n        SELECT SCOPE_IDENTITY() as last_id;\n    ";\n\n    $stmt = $conn->prepare($sql);\n    $stmt->execute();\n\n    $result = $stmt->fetch();\n    $last_id = $result['last_id'];\n\n    echo "New record has id: " . $last_id;\n\n} catch(PDOException $e) {\n    die("ERROR: Could not connect. " . $e->getMessage());\n}\n\n$conn = null;\n?>