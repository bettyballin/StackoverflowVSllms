use PHPMailer\PHPMailer\PHPMailer;\nuse PHPMailer\PHPMailer\Exception;\n\nrequire 'path/to/PHPMailer/src/Exception.php';\nrequire 'path/to/PHPMailer/src/PHPMailer.php';\nrequire 'path/to/PHPMailer/src/SMTP.php';\n\n$mail = new PHPMailer(true);\n\ntry {\n    //Server settings\n    $mail->isSMTP();                                            // Set mailer to use SMTP\n    $mail->Host       = '192.0.2.1';                           // Specify main and backup SMTP servers (use the specific IP here)\n    $mail->SMTPAuth   = true;                                   // Enable SMTP authentication\n    $mail->Username   = 'your_username@example.com';            // SMTP username\n    $mail->Password   = 'your_password';                        // SMTP password\n    $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;         // Enable TLS encryption, `ssl` also accepted\n    $mail->Port       = 587;                                    // TCP port to connect to\n\n    //Recipients\n    $mail->setFrom('from@example.com', 'Mailer');\n    $mail->addAddress('recipient@example.com', 'Joe User');     // Add a recipient\n\n    // Content\n    $mail->isHTML(true);                                  // Set email format to HTML\n    $mail->Subject = 'Here is the subject';\n    $mail->Body    = 'This is the HTML message body <b>in bold!</b>';\n    $mail->AltBody = 'This is the body in plain text for non-HTML mail clients';\n\n    $mail->send();\n    echo 'Message has been sent';\n} catch (Exception $e) {\n    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";\n}