<?php\n$mysqli = new mysqli("localhost", "user", "password", "database");\n\nif ($mysqli->connect_error) {\n    die('Connect Error (' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);\n}\n\n$query = "INSERT INTO your_table (column1, column2) VALUES ('value1', 'value2')";\n\nif ($mysqli->query($query)) {\n    $last_id = $mysqli->insert_id;\n    echo "Last inserted ID is: " . $last_id;\n} else {\n    echo "Error: " . $mysqli->error;\n}\n\n$mysqli->close();\n?>