use PHPMailer\PHPMailer\PHPMailer;\nuse PHPMailer\PHPMailer\Exception;\n\nrequire 'path/to/PHPMailer/src/Exception.php';\nrequire 'path/to/PHPMailer/src/PHPMailer.php';\nrequire 'path/to/PHPMailer/src/SMTP.php';\n\n$mail = new PHPMailer(true);\n\ntry {\n    //Server settings\n    $mail->SMTPDebug = 0;                                       // Disable verbose debug output\n    $mail->isSMTP();                                            // Set mailer to use SMTP\n    $mail->Host       = 'smtp.example.com';                     // Specify main and backup SMTP servers\n    $mail->SMTPAuth   = true;                                   // Enable SMTP authentication\n    $mail->Username   = 'your_email@example.com';               // SMTP username\n    $mail->Password   = 'your_email_password';                  // SMTP password\n    $mail->SMTPSecure = 'tls';                                  // Enable TLS encryption, `ssl` also accepted\n    $mail->Port       = 587;                                    // TCP port to connect to\n\n    // Recipients\n    $mail->setFrom('from@example.com', 'Mailer');\n    $mail->addAddress('recipient@example.com');                 // Add a recipient\n\n    // Content\n    $mail->isHTML(false);                                       // Set email format to plain text\n    $mail->Subject = 'Online Contact Request from Freese Custom Homes';\n    $mail->Body    = $message;\n\n    $mail->send();\n    echo 'Message has been sent';\n} catch (Exception $e) {\n    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";\n}