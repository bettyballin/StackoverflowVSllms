$stmt = $mysqli->prepare("SELECT * FROM messages WHERE recipient = ? AND `read` = 0");\n$stmt->bind_param("i", $userID);\n$stmt->execute();\n$result = $stmt->get_result();\n$msgs = $result->num_rows;