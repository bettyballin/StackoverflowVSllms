$pdo = new PDO('mysql:host=localhost;dbname=example', 'username', 'password');\n\n// Prepare a statement with parameterized query\n$stmt = $pdo->prepare('INSERT INTO users (name, email) VALUES (:name, :email)');\n\n// Bind parameters with user input data\n$stmt->bindParam(':name', $_POST['name']);\n$stmt->bindParam(':email', $_POST['email']);\n\n// Execute the statement\n$stmt->execute();