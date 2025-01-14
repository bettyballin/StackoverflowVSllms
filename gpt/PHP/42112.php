<?php\n$servername = "your_server";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n$target_name = "Dunn"; // The current page's record name\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Secure input\n$target_name = $conn->real_escape_string($target_name);\n\n// Query to get the target record with 3 previous and 3 next records\n$sql = "\n    (SELECT name FROM your_table WHERE name < '$target_name' ORDER BY name DESC LIMIT 3)\n    UNION\n    (SELECT name FROM your_table WHERE name = '$target_name')\n    UNION\n    (SELECT name FROM your_table WHERE name > '$target_name' ORDER BY name ASC LIMIT 3)\n";\n\n$result = $conn->query($sql);\n\n$names = [];\nif ($result->num_rows > 0) {\n    // Fetch all results\n    while ($row = $result->fetch_assoc()) {\n        $names[] = $row['name'];\n    }\n}\n\n// Close connection\n$conn->close();\n\n// Sort the names alphabetically\nsort($names);\n\n// Display the list\necho "<ul>";\nforeach ($names as $name) {\n    if ($name === $target_name) {\n        echo "<li><strong>$name</strong></li>";\n    } else {\n        echo "<li>$name</li>";\n    }\n}\necho "</ul>";\n?>