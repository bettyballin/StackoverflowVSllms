<?php\n   $to = "me@mydomain.com";\n   $subject = "Subject";\n   $message = "Message";\n   $headers = "From: no-reply@mydomain.com";\n\n   if (mail($to, $subject, $message, $headers)) {\n       echo "Mail sent successfully.";\n   } else {\n       echo "Mail sending failed.";\n       error_log("Mail sending failed for recipient: $to");\n   }\n   ?>