// Assuming the database connection is already established.\n\n$id = 1; // Use prepared statements or proper sanitization in real applications.\n$query = "SELECT * FROM `users` WHERE `id` = '$id'";\n\n// Execute the query\n$result = mysql_query($query);\n\nif (!$result) {\n    die('Invalid query: ' . mysql_error());\n}\n\n// Fetch the row as an associative array\n$row = mysql_fetch_assoc($result);\n\nif ($row) {\n    // Print the contents\n    echo "ID: " . $row['id'] . "\n";\n    echo "Username: " . htmlspecialchars($row['username']) . "\n";\n    // Avoid displaying the password!\n} else {\n    echo "No user found with ID: $id\n";\n}\n\n// Free result set\nmysql_free_result($result);