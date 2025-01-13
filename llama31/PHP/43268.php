$dsn = "mysql:host=your_host;dbname=your_database";\n$username = "your_user";\n$password = "your_password";\n\ntry {\n    $pdo = new PDO($dsn, $username, $password);\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    $query = "SELECT COUNT(DISTINCT `users_id`) AS `num_users` FROM `users_table`";\n    $stmt = $pdo->prepare($query);\n    $stmt->execute();\n\n    $row = $stmt->fetch(PDO::FETCH_ASSOC);\n    $nr_of_users = $row['num_users'];\n} catch (PDOException $e) {\n    $nr_of_users = 0;\n    echo "Error: " . $e->getMessage();\n}\n\n$pdo = null;