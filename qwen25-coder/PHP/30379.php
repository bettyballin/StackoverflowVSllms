$pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');\n$user_id = $_GET['user_id'];\n$stmt = $pdo->prepare("YOUR_QUERY_HERE");\n$stmt->bindParam(':user_id', $user_id, PDO::PARAM_INT);\n$stmt->execute();\n$results = $stmt->fetchAll(PDO::FETCH_ASSOC);