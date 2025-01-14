<?php\nfunction getPrimaryKey($pdo, $table) {\n    $stmt = $pdo->prepare("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = ? AND COLUMN_KEY = 'PRI'");\n    $stmt->execute([$table]);\n    $primaryKey = $stmt->fetchColumn();\n    \n    if ($primaryKey === false) {\n        throw new Exception("Primary key not found for table $table");\n    }\n    \n    return $primaryKey;\n}\n\n// Example usage:\ntry {\n    $pdo = new PDO('mysql:host=localhost;dbname=your_database', 'username', 'password');\n    $table = 'your_table';\n    $primaryKey = getPrimaryKey($pdo, $table);\n    $sql = sprintf("UPDATE %s SET %s = %s WHERE %s = %s", $table, 'column_name', 'value', $primaryKey, 'primary_key_value');\n    echo $sql;\n} catch (Exception $e) {\n    echo 'Error: ' . $e->getMessage();\n}\n?>