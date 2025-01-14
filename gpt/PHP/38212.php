$stmt = $pdo->prepare("INSERT INTO table (column1, column2, column3) VALUES (:param1, :param2, :param3)");\n\n// Binding an integer value\n$stmt->bindParam(':param1', $integerValue, PDO::PARAM_INT);\n\n// Binding a string value\n$stmt->bindParam(':param2', $stringValue, PDO::PARAM_STR);\n\n// Binding a LOB value (e.g., for binary data or large text)\n$stmt->bindParam(':param3', $lobValue, PDO::PARAM_LOB);\n\n$stmt->execute();