// Assuming $pdo is an instance of PDO\n$stmt = $pdo->prepare("INSERT INTO your_table (column1, column2) VALUES (:value1, :value2)");\n\n// Sanitize input values if necessary and bind them to the prepared statement\n$value1 = filter_input(INPUT_POST, 'input_name1', FILTER_SANITIZE_STRING);\n$value2 = filter_input(INPUT_POST, 'input_name2', FILTER_SANITIZE_STRING);\n\n$stmt->bindParam(':value1', $value1);\n$stmt->bindParam(':value2', $value2);\n\n// Execute the statement\n$stmt->execute();