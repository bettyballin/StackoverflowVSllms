use PHPMailer\PHPMailer\PHPMailer;\nuse PHPMailer\PHPMailer\Exception;\n\nrequire 'vendor/autoload.php';\n\n$mail = new PHPMailer(true);\ntry {\n    $mail->isSMTP();\n    $mail->Host = 'smtp.example.com';\n    $mail->SMTPAuth = true;\n    $mail->Username = 'your_email@example.com';\n    $mail->Password = 'your_password';\n    $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;\n    $mail->Port = 587;\n\n    $mail->setFrom('from@example.com', 'Mailer');\n    $mail->addAddress('recipient@example.com', 'Recipient');\n    $mail->addAttachment('/path/to/file.txt');\n    \n    $mail->isHTML(true);\n    $mail->Subject = 'Here is the subject';\n    $mail->Body    = 'This is the HTML message body <b>in bold!</b>';\n    $mail->AltBody = 'This is the body in plain text for non-HTML mail clients';\n\n    $mail->send();\n    echo 'Message has been sent';\n} catch (Exception $e) {\n    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";\n}