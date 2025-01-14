<?php\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "database_name";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$sql = "SELECT mid, AVG(rating) AS avg_rating FROM your_table_name GROUP BY mid ORDER BY avg_rating DESC LIMIT 5";\n$result = $conn->query($sql);\n\nif ($result->num_rows > 0) {\n    // Output data of each row\n    while($row = $result->fetch_assoc()) {\n        echo "Item ID: " . $row["mid"]. " - Average Rating: " . $row["avg_rating"]. "<br>";\n    }\n} else {\n    echo "No ratings found.";\n}\n$conn->close();\n?>