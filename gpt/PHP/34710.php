<?php\n$mysqli = new mysqli("hostname", "username", "password", "database");\n\n// Check connection\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n$search_keywords = $_GET["search_keywords"];\n$search_keywords = '%' . $search_keywords . '%';\n\n// Prepare the SQL statement\n$stmt = $mysqli->prepare("SELECT * FROM movies WHERE mov_title LIKE ?");\n$stmt->bind_param("s", $search_keywords);\n\n// Execute the statement\n$stmt->execute();\n\n// Get the result\n$result = $stmt->get_result();\n\n// Fetch and display the results\nwhile ($row = $result->fetch_assoc()) {\n    echo "Movie Title: " . $row['mov_title'] . "<br>";\n}\n\n// Close the statement and connection\n$stmt->close();\n$mysqli->close();\n?>