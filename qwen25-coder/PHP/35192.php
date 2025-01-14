try {\n    $pdo = new PDO('mysql:host=your_host;dbname=your_db', 'user', 'password');\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Assume `$proposedtag` has been validated via regex as above.\n    $stmt = $pdo->prepare("INSERT INTO tags (name) VALUES (:tag)");\n    $stmt->execute([':tag' => $proposedtag]);\n} catch (PDOException $e) {\n    echo 'Connection failed: ' . $e->getMessage();\n}