<?php\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "your_database";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$sql = "SELECT QNO FROM TABLE ORDER BY RAND() LIMIT 10";\n$result = $conn->query($sql);\n\n$columnArray = [];\nif ($result->num_rows > 0) {\n    while($row = $result->fetch_assoc()) {\n        $columnArray[] = $row['QNO'];\n    }\n} else {\n    echo "0 results";\n}\n\n$conn->close();\n\n// Now $columnArray contains your QNO values\nprint_r($columnArray);\n?>