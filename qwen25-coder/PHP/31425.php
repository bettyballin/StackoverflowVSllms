if(mail($to, $subject, $message, $headers)){\n       error_log("Email sent successfully.");\n   } else {\n       error_log("Failed to send email.");\n   }