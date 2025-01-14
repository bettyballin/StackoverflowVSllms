<?php\nuse PHPMailer\PHPMailer\PHPMailer;\nuse PHPMailer\PHPMailer\Exception;\n\nrequire 'vendor/autoload.php';\n\n$mail = new PHPMailer(true);\n\ntry {\n    //Server settings\n    $mail->isSMTP();                                            // Send using SMTP\n    $mail->Host       = 'smtp.example.com';                     // Set the SMTP server to send through\n    $mail->SMTPAuth   = true;                                   // Enable SMTP authentication\n    $mail->Username   = 'your_email@example.com';               // SMTP username\n    $mail->Password   = 'your_password';                        // SMTP password\n    $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;         // Enable TLS encryption; `PHPMailer::ENCRYPTION_SMTPS` encouraged\n    $mail->Port       = 587;                                    // TCP port to connect to\n\n    //Recipients\n    $mail->setFrom('your_email@example.com', 'Mailer');\n    $mail->addAddress('recipient@example.com', 'Recipient Name');     // Add a recipient\n\n    // Content\n    $mail->isHTML(true);                                  // Set email format to HTML\n    $mail->Subject = 'Here is the subject';\n    $mail->Body    = 'This is the HTML message body <b>in bold!</b>';\n    $mail->AltBody = 'This is the body in plain text for non-HTML mail clients';\n\n    $mail->send();\n    echo 'Message has been sent';\n} catch (Exception $e) {\n    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";\n}