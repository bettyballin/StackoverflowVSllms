$result = $db->query($sql);\nif ($result) {\n    $allRows = [];\n    while ($myData = $result->fetch_assoc()) {\n        $allRows[] = $myData;\n    }\n    // Use $allRows as an array of associative arrays here\n} else {\n    // Handle query error\n}