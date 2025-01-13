// Assuming you have a PDO connection named $conn\n$stmt = $conn->prepare("SELECT your_field FROM your_table WHERE your_condition = :condition");\n$stmt->bindParam(':condition', $yourCondition);\n$stmt->execute();\n$result = $stmt->fetch(PDO::FETCH_ASSOC);\n\nif ($result) {\n    $defaultText = $result['your_field'] ?? '';\n} else {\n    $defaultText = '';\n}