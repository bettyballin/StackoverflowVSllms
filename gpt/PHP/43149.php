$connection = new mysqli("hostname", "username", "password", "database");\n\nif ($connection->connect_error) {\n    die("Connection failed: " . $connection->connect_error);\n}\n\n$query = "SELECT * FROM `table`";\n$results = $connection->query($query);\n\nif ($results) {\n    if ($results->num_rows > 0) {\n        echo "There are rows in the table.";\n    } else {\n        echo "The table is empty.";\n    }\n} else {\n    echo "Error: " . $connection->error;\n}\n\n$connection->close();