<?php\n$servername = "your_server";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\n$conn = new mysqli($servername, $username, $password, $dbname);\n\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$sql = "SELECT name, position, office, age, start_date, salary FROM employees";\n$result = $conn->query($sql);\n\nif ($result->num_rows > 0) {\n    while($row = $result->fetch_assoc()) {\n        echo "<tr>\n                <td>{$row['name']}</td>\n                <td>{$row['position']}</td>\n                <td>{$row['office']}</td>\n                <td>{$row['age']}</td>\n                <td>{$row['start_date']}</td>\n                <td>{$row['salary']}</td>\n              </tr>";\n    }\n} else {\n    echo "0 results";\n}\n$conn->close();\n?>