$stmt = $_mysqli_session_write->prepare("INSERT INTO sessions (PHPSESSID, data) VALUES (?, ?) ON DUPLICATE KEY UPDATE data = VALUES(data)");\n$stmt->bind_param("ss", $PHPSESSID, $data);\n$stmt->execute();