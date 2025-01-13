<?php\n$stmt = $conn->prepare("SELECT * FROM books WHERE MATCH(title) AGAINST (?)");\n$stmt->bind_param("s", $searchTerm);\n\n$stmt->execute();\n$result = $stmt->get_result();\n\nwhile ($row = $result->fetch_assoc()) {\n    echo "Title: " . $row["title"] . "<br>";\n}\n?>