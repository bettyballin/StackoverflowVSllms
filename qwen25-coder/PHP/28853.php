<?php\n$keywords = array('apple', 'iphone', 'applications');\n$queryString = implode(" ", $keywords);\n\n// Assume $mysqli is your already created MySQLi connection\nmysqli_set_charset($mysqli, "utf8");\n\n$scores = [];\nforeach ($keywords as $keyword) {\n    // Prepare and execute a query for each keyword\n    $query = "\n        SELECT \n            id,\n            description,\n            (\n                CASE WHEN INSTR(description, ?) THEN 1 ELSE 0 END +\n                (LENGTH(description) - LENGTH(REPLACE(LOWER(description), LOWER(?), ''))) / LENGTH(?)\n            ) as score\n        FROM your_table_name\n    ";\n    $stmt = $mysqli->prepare($query);\n    if ($stmt === false) {\n        die("Error preparing statement: " . $mysqli->error);\n    }\n    // Use the keyword for both the CASE WHEN and LENGTH calculation to ensure case-insensitivity\n    $lowerKeyword = mb_strtolower($keyword, 'UTF-8');\n    $stmt->bind_param('sss', $keyword, $lowerKeyword, $lowerKeyword);\n    $stmt->execute();\n    $result = $stmt->get_result();\n\n    while ($row = $result->fetch_assoc()) {\n        if (isset($scores[$row['id']])) {\n            $scores[$row['id']] += $row['score'];\n        } else {\n            $scores[$row['id']] = $row['score'];\n        }\n    }\n\n    $stmt->close();\n}\n\n// Get unique keys so we can get result ids\n$resultIds = array_keys($scores);\nif (!empty($resultIds)) {\n    // Sort by scores in descending order\n    arsort($scores);\n\n    // Now you could fetch these sorted results from database (for demonstration, we will print)\n    $idsString = implode(',', $resultIds);\n    $queryFinal = "SELECT * FROM your_table_name WHERE id IN ($idsString) ORDER BY FIELD(id, $idsString)";\n    $finalResult = $mysqli->query($queryFinal);\n\n    while ($row = $finalResult->fetch_assoc()) {\n        echo htmlspecialchars($row['description']) . "<br>";\n    }\n}\n\n$mysqli->close();\n?>