<?php\n   use PHPMailer\PHPMailer\PHPMailer;\n   use PHPMailer\PHPMailer\Exception;\n\n   require 'vendor/autoload.php'; // Path to the composer autoload file\n\n   $mail = new PHPMailer(true);\n\n   try {\n       //Server settings\n       $mail->SMTPDebug = 2;                                       // Enable verbose debug output\n       $mail->isSMTP();                                            // Set mailer to use SMTP\n       $mail->Host       = 'smtp.gmail.com';                       // Specify main and backup SMTP servers\n       $mail->SMTPAuth   = true;                                   // Enable SMTP authentication\n       $mail->Username   = 'youremail@gmail.com';                  // SMTP username\n       $mail->Password   = 'your_gmail_password';                  // SMTP password\n       $mail->SMTPSecure = 'tls';                                  // Enable TLS encryption, `ssl` also accepted\n       $mail->Port       = 587;                                    // TCP port to connect to\n\n       //Recipients\n       $mail->setFrom('youremail@gmail.com', 'Mailer');\n       $mail->addAddress('recipient@example.com', 'Recipient Name'); // Add a recipient\n\n       // Content\n       $mail->isHTML(true);                                        // Set email format to HTML\n       $mail->Subject = 'Here is the subject';\n       $mail->Body    = 'This is the HTML message body <b>in bold!</b>';\n       $mail->AltBody = 'This is the body in plain text for non-HTML mail clients';\n\n       $mail->send();\n       echo 'Message has been sent';\n   } catch (Exception $e) {\n       echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";\n   }