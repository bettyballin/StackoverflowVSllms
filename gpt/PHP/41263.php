<?php\n$servername = "your_server";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_dbname";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$sql = "SELECT * FROM your_table";\n$result = $conn->query($sql);\n\n$data = array();\nif ($result->num_rows > 0) {\n    while($row = $result->fetch_assoc()) {\n        $data[] = $row;\n    }\n} else {\n    $data = "0 results";\n}\necho json_encode($data);\n\n$conn->close();\n?>