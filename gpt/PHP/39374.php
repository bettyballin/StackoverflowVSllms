<?php\n// Assuming $conn is your mysqli connection\n$query = "SELECT s.*, a.* FROM students LEFT JOIN addresses AS a ON s.id = a.student_id";\n$result = $conn->query($query);\n\n$finalArray = array();\n\nwhile ($row = $result->fetch_assoc()) {\n    $finalArray[] = array(\n        "s" => array(\n            "id" => $row['s.id'],\n            "name" => $row['s.name']\n        ),\n        "a" => array(\n            "id" => $row['a.id'],\n            "student_id" => $row['a.student_id'],\n            "address" => $row['a.address']\n        )\n    );\n}\n\nprint_r($finalArray);\n?>