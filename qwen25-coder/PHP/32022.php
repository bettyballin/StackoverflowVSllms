$conn = new PDO('mysql:host=localhost;dbname=testdb', 'username', 'password');\n   $stmt = $conn->prepare('SELECT * FROM users WHERE email = :email');\n   $stmt->execute(['email' => 'test@example.com']);\n   $user = $stmt->fetch();