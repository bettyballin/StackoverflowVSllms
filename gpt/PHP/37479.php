// To send HTML mail, the Content-type header must be set\n$headers  = 'MIME-Version: 1.0' . "\r\n";\n$headers .= 'Content-type: text/html; charset=iso-8859-1' . "\r\n";\n// Additional headers\n$headers .= 'From: mail@mailmaster.com' . "\r\n";\n\nif (sendEmailNow($email, $subject, $body, $headers)) {\n    // Email sent successfully\n} else {\n    // Email sending failed\n}\n\n// Function to send an email\nfunction sendEmailNow($email, $subject, $body, $headers) {\n    if (mail($email, $subject, $body, $headers)) {\n        return true;\n    } else {\n        return false;\n    }\n}