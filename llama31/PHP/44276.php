$stmt = $pdo->prepare('SELECT * FROM users WHERE email = :email');\n$stmt->bindParam(':email', $_POST['email']);\n$stmt->execute();