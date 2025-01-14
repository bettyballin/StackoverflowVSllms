<?php\n// Establish a PDO connection\n$dsn = 'mysql:host=localhost;dbname=your_database;charset=utf8mb4';\n$username = 'root'; // replace 'root' with your database username\n$password = '';     // replace '' with your database password\n\ntry {\n    $dbh = new PDO($dsn, $username, $password);\n    $dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Data to be inserted\n    $data = array(\n        'name' => $name,\n        'address' => $address,\n        'city' => $city,\n        'state' => $state,\n        'zip' => $zip\n    );\n\n    // Columns and placeholders for the SQL statement\n    $columns = implode(', ', array_keys($data));\n    $placeholders = ':' . implode(', :', array_keys($data));\n\n    // Prepare the SQL statement\n    $stmt = $dbh->prepare("INSERT INTO customer ($columns) VALUES ($placeholders)");\n\n    // Execute the statement with the data\n    $stmt->execute($data);\n\n} catch (PDOException $e) {\n    echo 'Connection failed: ' . $e->getMessage();\n}\n?>