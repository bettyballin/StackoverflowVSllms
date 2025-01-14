<?php\n// Database connection settings\n$host = 'your_host';\n$db   = 'your_database';\n$user = 'your_username';\n$pass = 'your_password';\n$charset = 'utf8mb4';\n\n$dsn = "mysql:host=$host;dbname=$db;charset=$charset";\n$options = [\n    PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,\n    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,\n    PDO::ATTR_EMULATE_PREPARES   => false,\n];\n\ntry {\n    $pdo = new PDO($dsn, $user, $pass, $options);\n} catch (\PDOException $e) {\n    throw new \PDOException($e->getMessage(), (int)$e->getCode());\n}\n\n// First query to select rows where the column is not 0\n$sqlSelect = "SELECT * FROM your_table WHERE NOT column = 0";\n$stmtSelect = $pdo->query($sqlSelect);\n\n// Fetch all results\n$results = $stmtSelect->fetchAll();\n\nforeach ($results as $result) {\n    // Extract field_x\n    $nox = $result['field_x'];\n\n    // Do whatever you need with $nox\n    // For example, let's assume we want to update another column based on $nox\n    $newValue = $nox * 2; // Just an example operation\n\n    // Prepare the update SQL statement using placeholders for safety\n    $sqlUpdate = "UPDATE your_table SET some_column = :newValue WHERE id = :id";\n    $stmtUpdate = $pdo->prepare($sqlUpdate);\n    \n    // Execute the update with bound parameters\n    $stmtUpdate->execute(['newValue' => $newValue, 'id' => $result['id']]);\n}\n\n?>