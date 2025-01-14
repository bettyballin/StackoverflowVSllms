// Example of inserting data into a database\n$mysqli = new mysqli('localhost', 'user', 'password', 'database');\n\nif ($stmt = $mysqli->prepare("INSERT INTO locations (latitude, longitude, user_id) VALUES (?, ?, ?)")) {\n    $lat = $_POST['lat'];\n    $lng = $_POST['lng'];\n    $userId = $_SESSION['user'];\n\n    $stmt->bind_param("dds", $lat, $lng, $userId);\n    $stmt->execute();\n    $stmt->close();\n}\n\n// Example of retrieving data for display\n$query = "SELECT latitude, longitude FROM locations WHERE user_id = ?";\n$stmt = $mysqli->prepare($query);\n$stmt->bind_param('s', $_SESSION['user']);\n$stmt->execute();\n$result = $stmt->get_result();\n\nwhile ($row = $result->fetch_assoc()) {\n    echo json_encode(["lat" => $row["latitude"], "lng" => $row["longitude"]]);\n}