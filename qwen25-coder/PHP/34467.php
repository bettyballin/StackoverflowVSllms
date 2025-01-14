<?php\n$servername = "localhost";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$csvFile = fopen('path/to/your/file.csv', 'r');\n\n// Skip the header row\nfgetcsv($csvFile);\n\nwhile (($data = fgetcsv($csvFile, 1000, ",")) !== FALSE) {\n    $sql = "INSERT INTO YourTableName (column1, column2, column3) VALUES (?, ?, ?)";\n    $stmt = $conn->prepare($sql);\n    $stmt->bind_param("sss", $data[0], $data[1], $data[2]);\n    \n    if (!$stmt->execute()) {\n        echo "Error: " . $sql . "<br>" . $conn->error;\n    }\n}\n\nfclose($csvFile);\n\n$conn->close();\n?>