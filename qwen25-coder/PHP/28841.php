$sqlq = "SELECT id,name FROM productcategories JOIN products ON productcategories.productid = products.id WHERE categoryid=?";\nif($allsubcats) {\n    foreach($allsubcats as $key => $data) {\n        $sqlq .= " OR categoryid=?";\n    }\n}\n\necho $sqlq;\n\n// Initialize parameters array and types string\n$params = [];\n$types = str_repeat("i", 1 + count($allsubcats)); // 'i' for integer\n\n// Add the main category ID to the params array\n$params[] = &$cat;\n\nif ($allsubcats) {\n    foreach($allsubcats as $key => $data) {\n        $params[] = &$data[0];\n    }\n}\n\nif ($query = $this->mysqli->connection->prepare($sqlq)) {\n    // Use call_user_func_array to bind parameters\n    array_unshift($params, $types); // Prepend types string\n    call_user_func_array([$query, 'bind_param'], $params);\n\n    $query->execute();\n    $query->bind_result($id,$name);\n    $query->store_result();\n\n    if ($query->num_rows > 0) {\n        while ($row = $query->fetch()) {\n            $allprods[] = ["id" => $id, "name" => $name]; // Store each row in an array\n        }\n    }\n\n    $query->close();\n} else {\n    echo "Error: " . $this->mysqli->connection->error; // Output error if any\n}