use PHPMailer\PHPMailer\PHPMailer;\nuse PHPMailer\PHPMailer\Exception;\n\nrequire 'path/to/PHPMailer/src/Exception.php';\nrequire 'path/to/PHPMailer/src/PHPMailer.php';\n\n$mail = new PHPMailer(true);\n\ntry {\n    $mail->isSMTP();\n    $mail->Host = 'your_smtp_host'; // Specify main and backup SMTP servers\n    $mail->SMTPAuth = true;                               // Enable SMTP authentication\n    $mail->Username = 'your_username';                    // SMTP username\n    $mail->Password = 'your_password';                    // SMTP password\n    $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;   // Enable TLS encryption, `ssl` also accepted\n    $mail->Port = 587;                                    // TCP port to connect to\n\n    //Recipients\n    $mail->setFrom('your_email@example.com', 'Your Name');\n    $mail->addAddress('recipient@example.com');\n\n    // Content\n    $mail->isHTML(true);                                  // Set email format to HTML\n    $mail->Subject = 'Test';\n    $mail->Body    = '<p>Test</p>';\n    $mail->AltBody = 'test';\n\n    // Encoding adjustments\n    $mail->Encoding = 'quoted-printable'; // or 'base64'\n\n    $mail->send();\n    echo 'Message has been sent';\n} catch (Exception $e) {\n    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";\n}