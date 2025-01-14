<?php\ntry {\n    $pdo = new PDO("mysql:host=localhost;dbname=database", "user", "password");\n    $statement = $pdo->query("SELECT COUNT(*) as count FROM your_table");\n\n    if ($row = $statement->fetch(PDO::FETCH_ASSOC)) {\n        echo "Number of rows: " . $row['count'];\n    }\n} catch (PDOException $e) {\n    echo "Error: " . $e->getMessage();\n}\n?>