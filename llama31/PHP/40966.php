$mail = new PHPMailer();\n$mail->IsSMTP();\n$mail->Host = 'your_smtp_host';\n$mail->Port = 25;\n$mail->From = 'your_email@example.com';\n$mail->AddAddress('recipient_email@example.com');\n$mail->Subject = 'Test Email';\n$mail->Body = 'This is a test email';\n$mail->Send();\n$mail->SmtpClose();