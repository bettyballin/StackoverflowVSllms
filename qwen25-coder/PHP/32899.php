$mysqli = new mysqli("localhost", "user", "password", "database");\n\n// Check connection\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n$stmt = $mysqli->prepare("INSERT IGNORE INTO my_table VALUES(?, ?, 1, NOW())");\n$stmt->bind_param("ii", $_SESSION['client']['id'], $_POST['id']);\n\n$stmt->execute();