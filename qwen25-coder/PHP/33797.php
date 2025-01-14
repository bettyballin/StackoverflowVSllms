<?php\n$pdo = new PDO('mysql:host=localhost;dbname=your_database', 'username', 'password');\n\n$stmt = $pdo->prepare("SELECT username FROM users WHERE id = :id");\n$id = intval($_GET['id']); // Convert to integer\n\nif (is_numeric($id)) {\n    $stmt->bindParam(':id', $id, PDO::PARAM_INT);\n    $stmt->execute();\n    $row = $stmt->fetch(PDO::FETCH_ASSOC);\n\n    if ($row) {\n        $user = htmlspecialchars($row['username'], ENT_QUOTES, 'UTF-8');\n        echo '<h1>User:' . $user . '</h1>';\n    } else {\n        echo '<h1>User not found</h1>';\n    }\n} else {\n    echo '<h1>Invalid input</h1>';\n}\n?>