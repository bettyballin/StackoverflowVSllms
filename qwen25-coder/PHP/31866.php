<?php\ntry {\n    $pdo = new PDO('mysql:host=your_host;dbname=your_db;charset=utf8', 'username', 'password');\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Replace spaces with hyphens and escape the input\n    $tag = str_replace(' ', '-', $_GET['tag']);\n    \n    // Prepare the SQL statement to prevent SQL injection\n    $stmt = $pdo->prepare("SELECT * FROM tags WHERE name = :tag");\n    $stmt->bindParam(':tag', $tag, PDO::PARAM_STR);\n    $stmt->execute();\n\n    // Fetch the result\n    $row = $stmt->fetch(PDO::FETCH_ASSOC);\n\n    if (!$row) {\n        exit('That tag does not exist.');\n    }\n\n    // Do something with your row data\n    echo "Tag found: " . htmlspecialchars($row['name']);\n\n} catch (PDOException $e) {\n    die("Could not connect to the database {$e->getMessage()}");\n}\n?>