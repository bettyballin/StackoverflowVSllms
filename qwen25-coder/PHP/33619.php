<?php\n// Assuming $mysqli is your database connection object\n$userId = 1; // This would be the ID of the user\n\n$query = "SELECT * FROM your_table WHERE userid = ?";\n$stmt = $mysqli->prepare($query);\n$stmt->bind_param("i", $userId);\n$stmt->execute();\n$result = $stmt->get_result();\n\nwhile ($row = $result->fetch_assoc()) {\n    echo "Record ID: " . $row['id'] . "<br>";\n    // You can also access other fields here\n}\n\n$stmt->close();\n?>