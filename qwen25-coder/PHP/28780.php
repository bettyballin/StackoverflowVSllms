<?php\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "database";\n\n$conn = new mysqli($servername, $username, $password, $dbname);\n\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n$keyword = $_GET['keyword'];\n// Sanitize the keyword if necessary\n\n$stmt = $conn->prepare("SELECT id, SUBSTRING(text_column, GREATEST(1, LOCATE(? , text_column) - 100), LEAST(200, LENGTH(text_column))) AS summary FROM your_table WHERE text_column LIKE CONCAT('%', ? , '%')");\n$stmt->bind_param("ss", $keyword, $keyword);\n$stmt->execute();\n$result = $stmt->get_result();\n\nwhile ($row = $result->fetch_assoc()) {\n    // Highlight the keyword in the summary\n    echo "<div>";\n    echo str_ireplace($keyword, "<strong>$keyword</strong>", htmlspecialchars($row['summary']));\n    echo "</div>";\n}\n\n$stmt->close();\n$conn->close();\n?>