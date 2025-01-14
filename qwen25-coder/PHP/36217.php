try {\n    $pdo = new PDO("pgsql:host=localhost;dbname=testdb", "username", "password");\n    // Prepare a statement for execution\n    $stmt = $pdo->prepare('SELECT * FROM users WHERE user_id = :id');\n    \n    // Bind parameters to the prepared statement and execute it\n    foreach ($userIds as $userId) {\n        $stmt->bindParam(':id', $userId, PDO::PARAM_INT);\n        $stmt->execute();\n        \n        // Fetch results\n        while ($row = $stmt->fetch()) {\n            echo $row['username'] . "<br>\n";\n        }\n    }\n\n} catch (PDOException $e) {\n    die("Could not connect to the database testdb :" . $e->getMessage());\n}