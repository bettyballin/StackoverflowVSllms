use PHPMailer\PHPMailer\PHPMailer;\nuse PHPMailer\PHPMailer\Exception;\n\n// Create a new PHPMailer instance\n$mail = new PHPMailer(true);\n\ntry {\n    // Server settings\n    $mail->isSMTP();\n    $mail->Host = 'smtp.gmail.com';\n    $mail->SMTPAuth = true;\n    $mail->Username = 'myemail@gmail.com'; // Your Gmail address\n    $mail->Password = 'yourpassword';      // Your Gmail password or App-specific password\n    $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS; // Use 'tls' for encryption\n    $mail->Port = 587; // Port 587 for TLS\n\n    // Recipients\n    $mail->setFrom('myemail@gmail.com', 'Your Name');\n    $mail->addAddress('recipient@example.com', 'Recipient Name');\n\n    // Content\n    $mail->isHTML(true);\n    $mail->Subject = 'Subject';\n    $mail->Body    = 'This is the HTML message body';\n    $mail->AltBody = 'This is the body in plain text for non-HTML mail clients';\n\n    $mail->send();\n    echo 'Message has been sent';\n} catch (Exception $e) {\n    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";\n}