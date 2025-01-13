try {\n    $pdo = new PDO('sqlite:your_database.sqlite');\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n    $pdo->exec("PRAGMA encoding = 'UTF-8';");\n} catch (PDOException $e) {\n    echo 'Connection failed: ' . $e->getMessage();\n}