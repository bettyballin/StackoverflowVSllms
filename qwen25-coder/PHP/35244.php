try {\n    $dsn = "mysql:host=your_host;dbname=your_db;charset=utf8mb4";\n    $pdo = new PDO($dsn, 'your_username', 'your_password');\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Prepare the SQL statement with placeholders\n    $stmt = $pdo->prepare("UPDATE avatar SET image_path = :imagePath WHERE avatar_id = :avatarId");\n\n    // Bind parameters to the prepared statement\n    $stmt->bindParam(':imagePath', $shackPath);\n    $stmt->bindParam(':avatarId', $row['cr_id'], PDO::PARAM_INT);\n\n    // Execute the statement\n    $stmt->execute();\n} catch (PDOException $e) {\n    echo "Error: " . $e->getMessage();\n}