<?php\n   // Track email opens with a simple 1x1 GIF tracking pixel\n\n   $recipientEmail = 'example@example.com';\n   $trackingPixelUrl = "http://yourserver.com/track.php?id=unique_identifier_for_email";\n\n   // Send email with the tracking pixel in the HTML body\n   $subject = "Important Notice";\n   $message = "<html><body>Hello, check out this <img src='$trackingPixelUrl' alt='' width='1' height='1'></body></html>";\n   $headers = "From: your-email@example.com\r\n";\n   $headers .= "Content-Type: text/html; charset=ISO-8859-1";\n\n   if(mail($recipientEmail, $subject, $message, $headers)) {\n       echo "Email sent successfully with tracking pixel.";\n   } else {\n       echo "Failed to send email.";\n   }