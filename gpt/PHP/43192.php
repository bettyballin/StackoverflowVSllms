$mysqli = new mysqli("localhost", "username", "password", "database");\n\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n$sql = "\n    SELECT * \n    FROM your_table \n    WHERE dateField1 >= CURDATE() \n      AND dateField2 >= CURDATE()\n";\n\nif ($result = $mysqli->query($sql)) {\n    while ($row = $result->fetch_assoc()) {\n        // Process each row\n        print_r($row);\n    }\n    $result->free();\n} else {\n    echo "Error: " . $mysqli->error;\n}\n\n$mysqli->close();