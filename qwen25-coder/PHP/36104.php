<?php\n   // track_open.php\n   include 'database_connection.php'; // Ensure you have a secure and safe connection\n\n   if (isset($_GET['id'])) {\n       $email_id = filter_input(INPUT_GET, 'id', FILTER_SANITIZE_STRING);\n       \n       // Log the open event in your database\n       $sql = "INSERT INTO email_opens (email_id, opened_at) VALUES (?, NOW())";\n       $stmt = $pdo->prepare($sql);\n       $stmt->execute([$email_id]);\n   }\n\n   header('Content-Type: image/png');\n   readfile('1x1.png'); // Send a 1x1 transparent PNG\n   ?>