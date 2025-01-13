<?php\n// process_data.php\n\n// Retrieve the JSON data from the request\n$data = json_decode(file_get_contents('php://input'), true);\n\nif ($data !== null) {\n    // Database connection (replace with your actual database credentials)\n    $servername = "your_server";\n    $username = "your_username";\n    $password = "your_password";\n    $dbname = "your_database";\n\n    // Create connection\n    $conn = new mysqli($servername, $username, $password, $dbname);\n\n    // Check connection\n    if ($conn->connect_error) {\n        die("Connection failed: " . $conn->connect_error);\n    }\n\n    // Example of storing data (adjust according to your data structure)\n    $stmt = $conn->prepare("INSERT INTO your_table (column1, column2) VALUES (?, ?)");\n    foreach ($data as $item) {\n        // Assuming $item is an associative array with keys 'column1' and 'column2'\n        $stmt->bind_param("ss", $item['column1'], $item['column2']);\n        $stmt->execute();\n    }\n\n    $stmt->close();\n    $conn->close();\n\n    echo "Data stored successfully";\n} else {\n    echo "No data received or invalid JSON";\n}\n?>