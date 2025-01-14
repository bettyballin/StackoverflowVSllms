<?php\n$db_user = "*****";\n$db_pass = "*****";\n$db_name = "*****";\n\n$conn = new mysqli("localhost", $db_user, $db_pass, $db_name);\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$match_id = intval($_GET['id']); // Sanitize input\n\n$stmt = $conn->prepare("SELECT usr2 FROM ***** WHERE id = ?");\n$stmt->bind_param("i", $match_id);\n$stmt->execute();\n$result = $stmt->get_result();\n$row = $result->fetch_assoc();\n\nif ($row && $row["usr2"] == -1) {\n    echo "1";\n} else {\n    echo "0";\n}\n\n$conn->close();\n?>