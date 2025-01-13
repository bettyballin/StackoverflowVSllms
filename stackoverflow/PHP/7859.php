function getCategoryCount($user, $conn) {\n    $result = array();\n    $query = "SELECT category, COUNT(id) AS count FROM Auctions\n              WHERE username=? GROUP BY category";\n    $stmt = $conn->prepare($query);\n    $stmt->bind_param('s',$user);\n    $stmt->execute();\n    $stmt->bind_result($cat, $count);\n    while ($stmt->fetch()) {\n        $result[$cat] = $count;\n    }\n    return $result;\n}