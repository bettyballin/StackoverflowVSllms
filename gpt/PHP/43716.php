<?php\n$servername = "your_server";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$url = $conn->real_escape_string($_POST['url']); // Ensure to sanitize user input\n\n// Check if URL already exists\n$sql = "SELECT 1 FROM urls WHERE url = '$url'";\n$result = $conn->query($sql);\n\nif ($result->num_rows > 0) {\n    echo "URL already exists.";\n} else {\n    // URL does not exist, insert new record\n    $insert_sql = "INSERT INTO urls (url) VALUES ('$url')";\n    if ($conn->query($insert_sql) === TRUE) {\n        echo "New URL inserted successfully.";\n    } else {\n        echo "Error: " . $insert_sql . "<br>" . $conn->error;\n    }\n}\n\n$conn->close();\n?>