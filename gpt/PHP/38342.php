<?php\n// Database connection\n$mysqli = new mysqli("localhost", "username", "password", "database");\n\n// Check connection\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n// Set the character set to UTF-8\n$mysqli->set_charset("utf8");\n\n// Retrieve the HTML description\n$id = 1; // example article ID\n$stmt = $mysqli->prepare("SELECT article_Desc FROM articles WHERE id = ?");\n$stmt->bind_param("i", $id);\n$stmt->execute();\n$stmt->bind_result($articleDesc);\n$stmt->fetch();\n$stmt->close();\n\n$mysqli->close();\n\n// Output the HTML content safely\n?>\n<!DOCTYPE html>\n<html lang="en">\n<head>\n    <meta charset="UTF-8">\n    <title>Article Description</title>\n</head>\n<body>\n    <div id="popupContent">\n        <?php echo $articleDesc; // Directly output HTML content ?>\n    </div>\n</body>\n</html>