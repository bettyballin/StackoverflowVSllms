<?php\n$galleries = array(1, 2, 5);\n$safeIds = implode(',', array_map('intval', $galleries));\n\n$query = "SELECT * FROM galleries WHERE id IN ($safeIds)";\n\n// Assuming you are using a MySQLi connection:\n// $conn is your database connection object\n$result = $conn->query($query);\n\nif ($result) {\n    while ($row = $result->fetch_assoc()) {\n        // Process each row\n    }\n} else {\n    echo "Error: " . $conn->error;\n}\n?>