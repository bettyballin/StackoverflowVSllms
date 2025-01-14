use PHPMailer\PHPMailer\PHPMailer;\nuse PHPMailer\PHPMailer\Exception;\n\nrequire 'vendor/autoload.php'; // Path to your Composer autoload file\n\nfunction sendMyMail($to, $subject, $body) {\n    $mail = new PHPMailer(true);\n\n    try {\n        //Server settings\n        $mail->SMTPDebug = 0;                                 // Enable verbose debug output\n        $mail->isSMTP();                                      // Set mailer to use SMTP\n        $mail->Host = 'smtp.example.com';                     // Specify main and backup SMTP servers\n        $mail->SMTPAuth = true;                               // Enable SMTP authentication\n        $mail->Username = 'email@example.com';                // SMTP username\n        $mail->Password = 'secret';                           // SMTP password\n        $mail->SMTPSecure = 'tls';                            // Enable TLS encryption, `ssl` also accepted\n        $mail->Port = 587;                                    // TCP port to connect to\n\n        //Recipients\n        $mail->setFrom('from@example.com', 'Mailer');\n        $mail->addAddress($to);\n\n        //Content\n        $mail->isHTML(true);                                  // Set email format to HTML\n        $mail->Subject = $subject;\n        $mail->Body    = $body;\n\n        $mail->send();\n    } catch (Exception $e) {\n        error_log("Message could not be sent. Mailer Error: {$mail->ErrorInfo}");\n    }\n}\n\n// Example usage\nsendMyMail('recipient@example.com', 'Here is the subject', '<p>This is the HTML message body <b>in bold!</b></p>');