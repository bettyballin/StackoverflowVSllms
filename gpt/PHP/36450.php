$pdo = new PDO('mysql:host=localhost;dbname=database', 'user', 'password');\n$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\nif (isset($_GET['variableNameX'])) {\n    $stmt = $pdo->prepare("SELECT * FROM table WHERE column = :variable");\n    $stmt->bindParam(':variable', $_GET['variableNameX']);\n    $stmt->execute();\n    // Fetch results, etc.\n}