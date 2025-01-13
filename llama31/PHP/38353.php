use PHPMailer\PHPMailer\PHPMailer;\nuse PHPMailer\PHPMailer\Exception;\n\nrequire 'vendor/autoload.php';\n\n$mail = new PHPMailer(true);\n\ntry {\n    $mail->SMTPDebug = 2;\n    $mail->isSMTP();\n    $mail->Host = 'smtp.gmail.com';\n    $mail->SMTPAuth = true;\n    $mail->Username = 'your-gmail-username@gmail.com';\n    $mail->Password = 'your-gmail-password';\n    $mail->SMTPSecure = 'tls';\n    $mail->Port = 587;\n\n    $mail->setFrom('your-gmail-username@gmail.com', 'Your Name');\n    $mail->addAddress('recipient-email@example.com', 'Recipient Name');\n\n    $mail->isHTML(true);\n    $mail->Subject = 'Error Notification';\n    $mail->Body = 'An error occurred: <b>Error message</b>';\n    $mail->AltBody = 'An error occurred: Error message';\n\n    $mail->send();\n    echo 'Message has been sent';\n} catch (Exception $e) {\n    echo 'Message could not be sent. Mailer Error: ', $mail->ErrorInfo;\n}