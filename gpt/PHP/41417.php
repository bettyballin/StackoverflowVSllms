<?php\n// Database connection\n$host = 'localhost';\n$user = 'root';\n$password = '';\n$database = 'your_database';\n\n$conn = new mysqli($host, $user, $password, $database);\n\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Process form data\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    $data = $_POST['data'];\n    \n    // Update the database (example query)\n    $sql = "UPDATE your_table SET your_column='$data' WHERE id=1";\n    if ($conn->query($sql) === TRUE) {\n        // Fetch the updated content\n        $result = $conn->query("SELECT your_column FROM your_table WHERE id=1");\n        $row = $result->fetch_assoc();\n        echo $row['your_column'];\n    } else {\n        echo "Error: " . $sql . "<br>" . $conn->error;\n    }\n}\n\n$conn->close();\n?>