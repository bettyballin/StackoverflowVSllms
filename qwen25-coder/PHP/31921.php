<?php\nheader("Content-Type: text/html; charset=UTF-8");\n\n// Database connection using PDO\n$dsn = 'mysql:host=localhost;dbname=your_database;charset=utf8';\n$username = 'your_username';\n$password = 'your_password';\n\ntry {\n    $pdo = new PDO($dsn, $username, $password);\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Fetch data\n    $stmt = $pdo->query("SELECT * FROM hindi");\n    while ($myrow = $stmt->fetch()) {\n        echo htmlspecialchars($myrow['data']) . "<br>";\n    }\n} catch (PDOException $e) {\n    echo 'Connection failed: ' . $e->getMessage();\n}\n?>