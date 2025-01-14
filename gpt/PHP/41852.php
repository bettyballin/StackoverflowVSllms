$query = "SELECT comment, userid, UNIX_TIMESTAMP(dtime)\n          FROM comment_updates\n          WHERE updateid=46546\n          ORDER BY dtime DESC\n          LIMIT 10";\n\nif ($stmt = $this->conn->prepare($query)) {\n    $stmt->execute();\n    \n    // Get metadata for the statement\n    $meta = $stmt->result_metadata();\n    \n    // Create an array to store the field names\n    $fields = array();\n    $row = array();\n\n    // Fetch field names and bind them to $row array\n    while ($field = $meta->fetch_field()) {\n        $fields[] = &$row[$field->name];\n    }\n    \n    // Call bind_result with dynamic parameters\n    call_user_func_array(array($stmt, 'bind_result'), $fields);\n    \n    $results = array();\n    while ($stmt->fetch()) {\n        $result = array();\n        foreach ($row as $key => $val) {\n            $result[$key] = $val;\n        }\n        $results[] = $result;\n    }\n    \n    return $results;\n    \n    $stmt->close();\n}