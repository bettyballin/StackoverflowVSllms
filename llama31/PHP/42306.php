function test_user($user) {\n    $conn = get_db_conn(); // Assuming this returns a PDO instance\n    $stmt = $conn->prepare('SELECT 1 FROM users WHERE uid = :uid');\n    $stmt->bindParam(':uid', $user);\n    $stmt->execute();\n    return $stmt->fetch() !== false;\n}