// Assuming $pdo is your PDO instance and all $_POST variables are meant to be used in the query\n$stmt = $pdo->prepare("INSERT INTO table_name (column1, column2) VALUES (:value1, :value2)");\n\n// Bind each parameter by looping through POST data\nforeach ($_POST as $key => $value) {\n    if ($stmt->bindParam(":$key", $_POST[$key])) {\n        // Binding successful for this variable\n    } else {\n        // Handle error in binding\n    }\n}\n\n$stmt->execute();