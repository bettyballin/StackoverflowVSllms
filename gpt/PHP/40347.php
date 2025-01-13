if ($stmt = $mysqli->prepare("SELECT * FROM sample WHERE t2 LIKE ?")) {\n    $tt2 = '%';\n    $stmt->bind_param("s", $tt2);\n    $stmt->execute();\n\n    $meta = $stmt->result_metadata();\n    while ($field = $meta->fetch_field()) {\n        $params[] = &$row[$field->name];\n    }\n\n    call_user_func_array(array($stmt, 'bind_result'), $params);\n\n    $result = array();\n    while ($stmt->fetch()) {\n        $c = array();\n        foreach($row as $key => $val) {\n            $c[$key] = performFunction($val);\n        }\n        $result[] = $c;\n    }\n    $stmt->close();\n}\n\n$mysqli->close();\nreturn $result;