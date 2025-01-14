function validateForeignKey($connection, $tableName, $columnName, $value) {\n    $stmt = $connection->prepare("SELECT 1 FROM `$tableName` WHERE `$columnName` = ?");\n    $stmt->bind_param('s', $value);\n    $stmt->execute();\n    $result = $stmt->get_result();\n    \n    if ($result->num_rows === 0) {\n        throw new InvalidArgumentException("Invalid foreign key value for column $columnName");\n    }\n}