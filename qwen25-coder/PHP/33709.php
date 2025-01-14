function connectToDB() {\n    return new mysqli("localhost", "my_user", "my_password", "world");\n}\n\nfunction fetchActiveUsers($conn) {\n    $query = "SELECT * FROM users WHERE active=1";\n    return $conn->query($query);\n}\n\nfunction displayUser($row) {\n    echo "id: " . htmlspecialchars($row["id"]) . " - Name: " . htmlspecialchars($row["name"]) . "<br>";\n    if ($row["admin"] == 1) {\n        echo "This user is an admin.<br>";\n    }\n}\n\n$conn = connectToDB();\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$result = fetchActiveUsers($conn);\nif ($result->num_rows > 0) {\n    while($row = $result->fetch_assoc()) {\n        displayUser($row);\n    }\n} else {\n    echo "0 results";\n}\n$conn->close();