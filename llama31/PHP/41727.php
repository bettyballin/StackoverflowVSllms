// store email data in a database\n$db = new PDO('mysql:host=localhost;dbname=emails', 'username', 'password');\n$stmt = $db->prepare('INSERT INTO emails (to, subject, message, send_at) VALUES (:to, :subject, :message, :send_at)');\n$stmt->execute([\n    ':to' => $to,\n    ':subject' => $subject,\n    ':message' => $message,\n    ':send_at' => date('Y-m-d H:i:s', strtotime('+1 day')), // send in 1 day\n]);\n\n// cron job script (e.g., send_emails.php)\n$db = new PDO('mysql:host=localhost;dbname=emails', 'username', 'password');\n$stmt = $db->prepare('SELECT * FROM emails WHERE send_at <= NOW()');\n$stmt->execute();\nwhile ($email = $stmt->fetch()) {\n    mail($email['to'], $email['subject'], $email['message'], $headers);\n    // delete email from database\n    $db->exec('DELETE FROM emails WHERE id = ' . $email['id']);\n}