<?php\n   $to = "your_email@example.com";\n   $subject = "Drupal Email Test";\n   $message = "This is a test email from Drupal 6.";\n   $headers = 'From: webmaster@localhost' . "\r\n" .\n              'Reply-To: webmaster@localhost' . "\r\n" .\n              'X-Mailer: PHP/' . phpversion();\n\n   if(mail($to, $subject, $message, $headers)) {\n       echo "Email successfully sent.";\n   } else {\n       echo "Failed to send email.";\n   }\n   ?>