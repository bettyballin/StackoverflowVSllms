$to = 'recipient@example.com';\n$subject = 'Test Email';\n$message = 'This is a test email.';\n$headers = 'From: realname@realhost.com' . "\r\n" .\n           'Reply-To: realname@realhost.com' . "\r\n" .\n           'X-Mailer: PHP/' . phpversion();\n\n// Additional parameters to set the envelope sender\n$additional_parameters = '-frealname@realhost.com';\n\nmail($to, $subject, $message, $headers, $additional_parameters);