<?php\n$to = 'test@example.com';\n$subject = 'Test Email';\n$message = 'This is a test email.';\n$headers = 'From: webmaster@example.com' . "\r\n" .\n           'Reply-To: webmaster@example.com' . "\r\n" .\n           'X-Mailer: PHP/' . phpversion();\n\nif (mail($to, $subject, $message, $headers)) {\n    echo 'Mail sent successfully.';\n} else {\n    echo 'Mail sending failed.';\n}\n?>