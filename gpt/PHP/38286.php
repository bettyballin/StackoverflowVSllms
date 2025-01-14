<?php\n$imageName = $_GET['image'];\n$conn = new mysqli('hostname', 'username', 'password', 'database');\n\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$sql = "SELECT image_data, mime_type FROM images WHERE image_name = ?";\n$stmt = $conn->prepare($sql);\n$stmt->bind_param('s', $imageName);\n$stmt->execute();\n$stmt->store_result();\n$stmt->bind_result($imageData, $mimeType);\n$stmt->fetch();\n\nif ($stmt->num_rows > 0) {\n    header("Content-Type: " . $mimeType);\n    echo $imageData;\n} else {\n    header("HTTP/1.0 404 Not Found");\n}\n\n$stmt->close();\n$conn->close();\n?>