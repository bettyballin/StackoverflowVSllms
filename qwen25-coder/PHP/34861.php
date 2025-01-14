function getLogsSafely($connection) {\n    $stmt = $connection->prepare("SELECT * FROM log WHERE reference_table_name = ? AND reference_id = ?");\n    $stmt->bind_param("si", $tableName, $referenceId);\n    // Set $tableName and $referenceId as needed\n    $stmt->execute();\n    $result = $stmt->get_result();\n\n    // Process results similarly to the previous function\n}