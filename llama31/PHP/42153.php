$pdo = new PDO('mysql:host=localhost;dbname=yourdb', 'yourusername', 'yourpassword');\n\n$stmt = $pdo->prepare('SELECT mid, (SUM(rating) / COUNT(*)) * (COUNT(*) / (COUNT(*) + 1)) as weighted_avg FROM ratings GROUP BY mid ORDER BY weighted_avg DESC LIMIT 5');\n$stmt->execute();\n\n$result = $stmt->fetchAll(PDO::FETCH_ASSOC);\n\nprint_r($result);