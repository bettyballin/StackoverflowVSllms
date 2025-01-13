<?php\n// Database connection (reuse the connection code from above)\n\n// Prepare and execute the SQL statement\n$sql = "SELECT text_field FROM your_table WHERE id = :id";\n$stmt = $pdo->prepare($sql);\n$stmt->bindParam(':id', $id, PDO::PARAM_INT);\n$stmt->execute();\n\n$result = $stmt->fetch(PDO::FETCH_ASSOC);\nif ($result) {\n    // Display the text while preserving special characters\n    $text = htmlspecialchars($result['text_field'], ENT_QUOTES, 'UTF-8');\n    echo nl2br($text); // Converts newlines to <br> for HTML display\n} else {\n    echo "No record found.";\n}\n?>