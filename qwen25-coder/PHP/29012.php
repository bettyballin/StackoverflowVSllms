$dsn = 'mysql:host=localhost;dbname=yourdb;charset=utf8';\n$username = 'yourusername';\n$password = 'yourpassword';\n\ntry {\n    $pdo = new PDO($dsn, $username, $password);\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Build placeholders\n    setPlaceholders($psValues, $placeholdersSet, '?');\n    setPlaceholders($psWhere, $placeholdersWhere, ':');\n\n    $query = "UPDATE `$psTableName` SET ";\n    $query .= implode(', ', $placeholdersSet);\n    $query .= " WHERE ";\n    $query .= implode(' AND ', $placeholdersWhere);\n\n    // Prepare statement\n    $stmt = $pdo->prepare($query);\n\n    // Bind parameters\n    foreach ($psValues as $key => $value) {\n        $stmt->bindValue(":$key", $value);\n    }\n    foreach ($psWhere as $key => $value) {\n        $stmt->bindValue(":$key", $value);\n    }\n\n    // Execute\n    $stmt->execute();\n} catch (PDOException $e) {\n    echo 'Connection failed: ' . $e->getMessage();\n}\n\nfunction setPlaceholders(array &$values, array &$placeholders, string $prefix = ':') {\n    foreach ($values as $key => &$value) {\n        if (!isset($placeholders)) {\n            $placeholders = [];\n        }\n        $placeholders[] = "`$key` = {$prefix}{$key}";\n    }\n}