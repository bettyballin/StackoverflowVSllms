<?php\ntry {\n    // Create a new PDO object\n    $pdo = new PDO('mysql:host=localhost;dbname=database', 'username', 'password');\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // Prepare an SQL statement with placeholders\n    $stmt = $pdo->prepare("INSERT INTO users (username, email) VALUES (:username, :email)");\n\n    // Bind user input to the statement\n    $stmt->bindParam(':username', $_POST['username']);\n    $stmt->bindParam(':email', $_POST['email']);\n\n    // Execute the statement\n    $stmt->execute();\n} catch (PDOException $e) {\n    die("Error: " . $e->getMessage());\n}\n?>