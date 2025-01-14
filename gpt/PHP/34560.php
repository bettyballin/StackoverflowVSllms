<?php\n   // Database connection\n   $mysqli = new mysqli("hostname", "username", "password", "database");\n\n   // Get current time\n   $current_time = date('Y-m-d H:i:s');\n\n   // Fetch emails that need to be sent\n   $result = $mysqli->query("SELECT * FROM scheduled_emails WHERE scheduled_time <= '$current_time' AND sent = 0");\n   \n   while ($row = $result->fetch_assoc()) {\n       // Send the email\n       mail($row['recipient'], $row['subject'], $row['message'], $row['headers']);\n\n       // Mark email as sent\n       $stmt = $mysqli->prepare("UPDATE scheduled_emails SET sent = 1 WHERE id = ?");\n       $stmt->bind_param("i", $row['id']);\n       $stmt->execute();\n       $stmt->close();\n   }\n   ?>