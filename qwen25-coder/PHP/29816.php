<?php\n$pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');\n\n$stmt = $pdo->prepare("SELECT news.*, users.username \n                       FROM news \n                       INNER JOIN users ON news.user_id = users.id \n                       WHERE news.id = :id");\n\n$id = intval($_GET['id']);\n$stmt->bindParam(':id', $id, PDO::PARAM_INT);\n\ntry {\n    $stmt->execute();\n    $news = $stmt->fetch(PDO::FETCH_ASSOC);\n    if ($news) {\n        echo "News Title: " . htmlspecialchars($news['title']) . "<br>";\n        echo "Author: " . htmlspecialchars($news['username']);\n    } else {\n        echo "No news found.";\n    }\n} catch (PDOException $e) {\n    echo "Error: " . $e->getMessage();\n}\n?>