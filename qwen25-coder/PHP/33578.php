<?php\n   $to = "xxx@yahoo.com";\n   $subject = "Form Submission Results";\n   $message = "Name: xxx\nE-Mail: xxx@yahoo.com\nMessage: hey test message";\n   $headers = "From: webmaster@example.com\r\n" .\n              "Reply-To: xxx@gmail.com\r\n" .\n              "X-Mailer: PHP/" . phpversion();\n\n   if(mail($to, $subject, $message, $headers)) {\n       echo "Mail Sent.";\n   } else {\n       echo "Failed to Send Mail.";\n   }\n   ?>