// Using PHPMailer to send an email\nuse PHPMailer\PHPMailer\PHPMailer;\n$mail = new PHPMailer(true);\n\n$mail->isSMTP();\n$mail->Host       = 'smtp.example.com';\n$mail->SMTPAuth   = true;\n$mail->Username   = 'your_username@example.com';\n$mail->Password   = 'your_password';\n$mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;\n$mail->Port       = 587;\n\n$mail->setFrom('from@example.com', 'Your Name');\n$mail->addAddress('recipient@example.com');\n\n$mail->isHTML(true);\n$mail->Subject = 'Here is the subject';\n$mail->Body    = 'This is the HTML message body <b>in bold!</b>';\n$mail->AltBody = 'This is the body in plain text for non-HTML mail clients';\n\n$mail->send();