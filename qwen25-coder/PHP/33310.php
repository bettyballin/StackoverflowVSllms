<?php\n\ninclude '../connection.php';\n\n$ID = isset($_GET['id']) ? intval($_GET['id']) : 0;\n\nif ($ID <= 0) {\n    http_response_code(400);\n    die("Invalid ID");\n}\n\n$query = "SELECT image, image_type FROM images WHERE image_id = ?";\n$stmt = $conn->prepare($query);\n\nif ($stmt === false) {\n    error_log("Failed to prepare statement: " . htmlspecialchars($conn->error));\n    http_response_code(500);\n    die("Internal Server Error");\n}\n\n$stmt->bind_param('i', $ID);\n$stmt->execute();\n$result = $stmt->get_result();\n\nif ($result->num_rows === 0) {\n    http_response_code(404);\n    die("Image not found");\n}\n\n$row = $result->fetch_assoc();\n$image_data = $row['image'];\n$image_type = $row['image_type'];\n\nheader("Content-type: " . $image_type);\necho $image_data;\n\n$stmt->close();\n$conn->close();\n\n?>