$stmt = $mysqli->prepare("\n  (SELECT * FROM posts ORDER BY date ASC LIMIT 1)\n  UNION ALL\n  (SELECT * FROM posts ORDER BY date DESC LIMIT ?, ?)\n");\n$stmt->bind_param("ii", $limit, $max);\n$stmt->execute();\n$result = $stmt->get_result();