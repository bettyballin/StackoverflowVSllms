<?php\n$dsn = 'pgsql:host=your_host;dbname=your_dbname';\n$username = 'your_username';\n$password = 'your_password';\n\ntry {\n    $pdo = new PDO($dsn, $username, $password);\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Prepare the statement\n    $statement = $pdo->prepare("SELECT * FROM users WHERE email = :email");\n\n    // Bind the parameter\n    $email = 'user@example.com';\n    $statement->bindParam(':email', $email, PDO::PARAM_STR);\n\n    // Execute the statement\n    $statement->execute();\n\n    // Fetch and display the results\n    $result = $statement->fetchAll(PDO::FETCH_ASSOC);\n\n    foreach ($result as $row) {\n        echo 'User ID: ' . $row['id'] . '<br>';\n        echo 'User Email: ' . $row['email'] . '<br>';\n    }\n} catch (PDOException $e) {\n    echo 'Connection failed: ' . $e->getMessage();\n}\n?>