// Assuming $types and $params are defined arrays where\n// $types contains string types for each parameter (e.g., 'ssi' for string, string, int)\n// $params is an array holding the respective values\n\n$stmt = $mysqli->prepare("SELECT * FROM your_table WHERE param1=? AND param2=?");\n\nif ($stmt === false) {\n    throw new Exception($mysqli->error);\n}\n\nif (!empty($types) && !empty($params)) {\n    // Prepend the types string to the params array\n    $ref = array_merge((array)$types, $params);\n\n    // Use call_user_func_array to bind parameters dynamically\n    call_user_func_array(array($stmt, 'bind_param'), ref);\n}\n\n$stmt->execute();\n// ... further handling of result set ...