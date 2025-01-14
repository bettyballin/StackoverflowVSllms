// Assuming $mysqli is your mysqli connection object\n$query = "SELECT s.*, a.* FROM students LEFT JOIN addresses AS a";\n$result = $mysqli->query($query);\n\n$sortedArray = [];\nwhile ($row = $result->fetch_assoc()) {\n    $id = $row['id']; // Assuming 's.id' is the unique identifier for student\n    $sortedArray[$id] = [\n        "s" => [\n            "id" => $row['id'],\n            "name" => $row['name']\n        ],\n        "a" => [\n            "id" => $row['a_id'], // Assuming 'a.id' is aliased as 'a_id'\n            "student_id" => $row['student_id'],\n            "address" => $row['address']\n        ]\n    ];\n}\n\nprint_r($sortedArray);