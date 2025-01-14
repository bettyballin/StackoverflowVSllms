// Prepare a statement for execution\n$stmt = $database->prepare('SELECT * FROM widgets WHERE something = :somethingElse');\n\n// Bind a value to the parameter\n$somethingElseValue = 'your_dynamic_value_here';\n$stmt->bindParam(':somethingElse', $somethingElseValue);\n\n// Execute the prepared statement\n$stmt->execute();\n\n// Fetch and loop through the results\nwhile ($results = $stmt->fetch(PDO::FETCH_ASSOC)) {\n    echo $results["widget_name"];\n}