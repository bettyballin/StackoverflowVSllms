// Assume $mysqli is your database connection and $userId and $cookiePart are the cookie values you retrieved\n$userId = $_COOKIE['user_id'];\n$cookiePart = $_COOKIE['cookie_part'];\n\n$stmt = $mysqli->prepare("SELECT * FROM users WHERE id = ? AND part_of_password = ?");\n$stmt->bind_param("ss", $userId, $cookiePart);\n$stmt->execute();\n$result = $stmt->get_result();\n\nif ($result->num_rows > 0) {\n    // User is authenticated\n} else {\n    // Authentication failed\n}