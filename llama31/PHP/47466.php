$stmt = $db->prepare("SELECT * from tbl_bugresponse WHERE bugid = ? ORDER BY time");\n$stmt->bind_param("i", $id);\n$stmt->execute();\n$result = $stmt->get_result();\nwhile($posts = $result->fetch_assoc()) {\n    // your code here\n}