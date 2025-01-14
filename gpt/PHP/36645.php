<?php\n// Database connection details\n$servername = "localhost";\n$username = "music123_sri";\n$password = "password";\n$dbname = "music123_telugu";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Data to insert\n$xmlString = "<Your XML data here>";\n\n// Prepare and bind\n$stmt = $conn->prepare("INSERT INTO xml (File) VALUES (?)");\n$stmt->bind_param("s", $xmlString);\n\n// Execute statement\nif ($stmt->execute()) {\n    echo "New record created successfully";\n} else {\n    echo "Error: " . $stmt->error;\n}\n\n// Close the statement\n$stmt->close();\n\n// Retrieve data\n$sql = "SELECT File FROM xml";\n$result = $conn->query($sql);\n\nif ($result->num_rows > 0) {\n    // Output data of each row\n    while ($row = $result->fetch_assoc()) {\n        echo "File: " . $row["File"] . "<br>";\n    }\n} else {\n    echo "0 results";\n}\n\n// Close connection\n$conn->close();\n?>