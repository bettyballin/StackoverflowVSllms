<?php\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    // Retrieve user ID from POST data\n    $userId = isset($_POST['userId']) ? intval($_POST['userId']) : null;\n\n    if ($userId !== null) {\n        try {\n            // Connect to your database (make sure to use prepared statements to prevent SQL injection)\n            $pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');\n            $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n            // Prepare and execute the query\n            $stmt = $pdo->prepare("INSERT INTO your_table (user_id) VALUES (:userId)");\n            $stmt->execute(['userId' => $userId]);\n\n            echo "User saved successfully!";\n        } catch (PDOException $e) {\n            echo "Error: " . $e->getMessage();\n        }\n    } else {\n        echo "Invalid user ID provided.";\n    }\n} else {\n    echo "Only POST requests are allowed.";\n}\n?>