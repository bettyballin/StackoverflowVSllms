<?php\n$servername = "your_server";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_db";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$sql = "DELETE FROM foo WHERE bar = 'stuff'";\n\nif ($conn->query($sql) === TRUE) {\n    echo "Record deleted successfully";\n    // Optionally, check how many rows were affected\n    if ($conn->affected_rows > 0) {\n        echo ". Number of records deleted: " . $conn->affected_rows;\n    } else {\n        echo ". No records matched the WHERE clause.";\n    }\n} else {\n    echo "Error deleting record: " . $conn->error;\n}\n\n$conn->close();\n?>