// Assuming $today is a properly formatted date string\n$today = '2023-10-10'; // Example date\n\n// Create a parameterized query\n$sql = 'SELECT status, COUNT(*) as total \n        FROM reported_issues \n        WHERE date_reported >= :today \n        AND status IN (0, 1) \n        GROUP BY status';\n\n$stmt = $db->prepare($sql);\n$stmt->bindParam(':today', $today, PDO::PARAM_STR);\n$stmt->execute();\n\nwhile ($row = $stmt->fetch()) {\n    switch ($row['status']) {\n        case 0:\n            $totalIssuesToday = $row['total'];\n            break;\n\n        case 1:\n            $totalIssuesClosedToday = $row['total'];\n            break;\n    }\n}