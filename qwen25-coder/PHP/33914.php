// Assuming $sender_id and $receiver_id are already set\n$mysqli = new mysqli("localhost", "user", "password", "database");\n\nif ($mysqli->connect_error) {\n    die('Connect Error (' . $mysqli->connect_errno . ') '\n            . $mysqli->connect_error);\n}\n\n$stmt = $mysqli->prepare("SELECT * FROM tblusers WHERE usrID IN (?, ?)");\n$stmt->bind_param("ii", $sender_id, $receiver_id);\n$stmt->execute();\n$result = $stmt->get_result();\n\nwhile ($row = $result->fetch_assoc()) {\n    echo htmlspecialchars($row['usrFirstName']) . ' ' . htmlspecialchars($row['usrLastName']) . '<br>';\n}\n\n$stmt->close();\n$mysqli->close();