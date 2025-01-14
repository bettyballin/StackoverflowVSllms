try {\n    // Assuming $pdo is an instance of PDO\n    $sql = "INSERT INTO players (player_name, base_name, location, AB, CD, EF) VALUES (:playerName, :baseName, :location, :AB, :CD, :EF)";\n    $stmt = $pdo->prepare($sql);\n    $stmt->execute([\n        ':playerName' => $playerName,\n        ':baseName' => $baseName,\n        ':location' => $location,\n        ':AB' => $values['AB'],\n        ':CD' => $values['CD'],\n        ':EF' => $values['EF']\n    ]);\n} catch (Exception $e) {\n    echo "Error: " . $e->getMessage();\n}