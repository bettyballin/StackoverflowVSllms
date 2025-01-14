<?php\n$mysqli = new mysqli("localhost", "my_user", "my_password", "world");\n\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n$stmt = $mysqli->prepare("CALL GetEmployeeDetails(?)");\n$stmt->bind_param("i", $employeeId);\n\n$employeeId = 1;\n$stmt->execute();\n$result = $stmt->get_result();\n\nwhile ($row = $result->fetch_assoc()) {\n    echo "Name: " . $row['name'] . "<br>";\n}\n\n$stmt->close();\n$mysqli->close();\n?>