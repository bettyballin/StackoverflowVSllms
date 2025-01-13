$dsn = 'mysql:host=host;dbname=dbname';\n$username = 'username';\n$password = 'password';\n\ntry {\n    $pdo = new PDO($dsn, $username, $password);\n} catch (PDOException $e) {\n    echo 'Connection failed: ' . $e->getMessage();\n}\n\n$items = $pdo->query("SELECT * FROM table_name");\n\nwhile($item = $items->fetchObject()) {\n    my_function($item->rowname);\n}