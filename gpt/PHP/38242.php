<?php\ntry {\n    // Create a connection\n    $pdo = new PDO("mysql:host=localhost;dbname=database", "username", "password");\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Perform a query\n    $sql = "SELECT * FROM your_table";\n    $stmt = $pdo->query($sql);\n\n    // Count the number of rows\n    $row_count = $stmt->rowCount();\n    echo "Number of rows: " . $row_count;\n} catch (PDOException $e) {\n    echo "Error: " . $e->getMessage();\n}\n\n// Close the connection\n$pdo = null;\n?>