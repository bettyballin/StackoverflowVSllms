$pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');\n$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n$tag = $_POST['tag']; // or however you get your input\nif (preg_match('/[^\\\/a-zA-Z0-9._@\'-]/', $tag)) {\n    echo "Invalid tag";\n} else {\n    $stmt = $pdo->prepare('INSERT INTO tags (tag) VALUES (:tag)');\n    $stmt->bindParam(':tag', $tag, PDO::PARAM_STR);\n    $stmt->execute();\n    echo "Tag inserted successfully";\n}