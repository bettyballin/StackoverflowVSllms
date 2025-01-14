<?php\n$session_id = session_id(); // Example for PHPSESSID, adjust as necessary\n$data = 'your_session_data'; // Data to store\n\n// Assuming $mysqli is your MySQLi connection object\n\n$stmt = $mysqli->prepare("REPLACE INTO sessions (PHPSESSID, data) VALUES (?, ?)");\nif ($stmt === false) {\n    die('Prepare failed: ' . htmlspecialchars($mysqli->error));\n}\n\n$result = $stmt->bind_param("ss", $session_id, $data);\nif ($result === false) {\n    die('Binding parameters failed: ' . htmlspecialchars($stmt->error));\n}\n\n$result = $stmt->execute();\nif ($result === false) {\n    die('Execute failed: ' . htmlspecialchars($stmt->error));\n}\n\necho "Session data replaced/inserted successfully.";\n$stmt->close();\n?>