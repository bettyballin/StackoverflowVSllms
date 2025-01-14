<?php\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    $link = filter_input(INPUT_POST, 'link', FILTER_SANITIZE_URL);\n\n    // Validate URL and update the counter in your database\n    // Example using PDO for database interaction\n\n    try {\n        $pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');\n        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n        $stmt = $pdo->prepare('UPDATE link_counter SET clicks = clicks + 1 WHERE url = :url');\n        $stmt->execute(['url' => $link]);\n\n    } catch (PDOException $e) {\n        // Handle database error\n        error_log($e->getMessage());\n    }\n}\n?>