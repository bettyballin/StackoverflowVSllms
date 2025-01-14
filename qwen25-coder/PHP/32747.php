$pdo = new PDO('mysql:host=localhost;dbname=test', 'user', 'password');\n$stmt = $pdo->query("SELECT id, price, created_at FROM products WHERE id = 1");\n$product = $stmt->fetch(PDO::FETCH_ASSOC);\n\n// Manually cast the data types after fetching:\n$product['id'] = (int)$product['id'];\n$product['price'] = (float)$product['price'];\n$product['created_at'] = \DateTime::createFromFormat('Y-m-d H:i:s', $product['created_at']);