<?php\n$to = "recipient@example.com";\n$subject = "Test email from localhost";\n$message = "Hello, this is a test email sent from localhost using Gmail's SMTP server.";\n$headers = "From: your_email@gmail.com";\n\nmail($to, $subject, $message, $headers);\n?>