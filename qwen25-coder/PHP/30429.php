<?php\n// Assuming you have a database connection $pdo\n\n$to = 'recipient@example.com';\n$subject = 'Subject';\n$message = 'Message';\n$name = $_POST['name'];\n$email = $_POST['email'];\n\n$scheduled_time = date('Y-m-d H:i:s', strtotime('+1 day'));\n\n$stmt = $pdo->prepare("INSERT INTO email_queue (to_address, subject, message, from_name, reply_to, scheduled_time) VALUES (?, ?, ?, ?, ?, ?)");\n$stmt->execute([$to, $subject, $message, $name, $email, $scheduled_time]);\n?>