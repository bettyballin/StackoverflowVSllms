$guests = array();\n$sql = "SELECT * FROM `guestlist`";\n\n// Create a connection (replace 'hostname', 'username', 'password', 'database' with your actual database credentials)\n$connection = new mysqli('hostname', 'username', 'password', 'database');\n\nif ($connection->connect_error) {\n    die("Connection failed: " . $connection->connect_error);\n}\n\n$result = $connection->query($sql);\n\nif ($result->num_rows > 0) {\n    while ($row = $result->fetch_assoc()) {\n        $guests[] = $row['name'];\n    }\n} else {\n    echo "0 results";\n}\n\n$connection->close();