function create($table, $fields, $values, $conn) {\n    $sql = "INSERT INTO $table (" . implode(", ", $fields) . ") VALUES (" . implode(", ", array_fill(0, count($values), '?')) . ")";\n    $stmt = $conn->prepare($sql);\n    $stmt->bind_param(str_repeat('s', count($values)), ...$values);\n    $stmt->execute();\n    return $stmt->affected_rows;\n}