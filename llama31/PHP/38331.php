$pdo = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');\n$pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);