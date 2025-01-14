$mysqli = new mysqli("host", "user", "password", "database");\nif ($mysqli->connect_error) {\n    die('Connect Error (' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);\n}\n\n$sql = "INSERT INTO table (column1, column2, ...) VALUES (?, ?, ...)";\n$stmt = $mysqli->prepare($sql);\n// Bind variables to the prepared statement as parameters and execute it\n$stmt->bind_param("sss", $var1, $var2, ...); // Use appropriate types for your data\nif ($stmt->execute()) {\n    echo "New record created successfully. Last inserted ID is: " . $mysqli->insert_id;\n} else {\n    die('Error: ' . $mysqli->error);\n}\n\n$stmt->close();\n$mysqli->close();