<?php\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "database";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$course_id = 4; // Example course id\n$sql = "SELECT * FROM prerequisites WHERE course_id = $course_id";\n$result = $conn->query($sql);\n\nif ($result->num_rows > 0) {\n    echo "<ul>";\n    while($row = $result->fetch_assoc()) {\n        echo "<li>" . $row["requirement"] . " (" . $row["relation"] . ")</li>";\n    }\n    echo "</ul>";\n} else {\n    echo "No prerequisites found.";\n}\n\n$conn->close();\n?>