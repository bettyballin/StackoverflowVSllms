<?php\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    $completed = $_POST['completed'];\n    $hoursWorked = $_POST['hoursWorked'];\n    $whoWorked = $_POST['whoWorked'];\n\n    // Validate and sanitize input data\n    $completed = filter_var($completed, FILTER_SANITIZE_STRING);\n    $hoursWorked = filter_var($hoursWorked, FILTER_SANITIZE_NUMBER_INT);\n    $whoWorked = filter_var($whoWorked, FILTER_SANITIZE_STRING);\n\n    // Update the database with the new data\n    // Example using PDO for database interaction\n    try {\n        $pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');\n        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n        $stmt = $pdo->prepare('UPDATE your_table SET completed = ?, hours_worked = ?, who_worked = ? WHERE your_condition');\n        $stmt->execute([$completed, $hoursWorked, $whoWorked]);\n\n        echo 'Update successful';\n    } catch (PDOException $e) {\n        echo 'Database error: ' . $e->getMessage();\n    }\n}\n?>