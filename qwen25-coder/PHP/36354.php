// Calling the stored procedure from PHP\n$mysqli = new mysqli("localhost", "user", "password", "database");\n\nif ($mysqli->connect_error) {\n    die('Connect Error (' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);\n}\n\nif ($stmt = $mysqli->prepare("CALL GetAverageData()")) {\n    $stmt->execute();\n    $result = $stmt->get_result();\n    while ($row = $result->fetch_assoc()) {\n        echo "Average Data: " . $row['average_data'];\n    }\n    $stmt->close();\n}\n\n$mysqli->close();