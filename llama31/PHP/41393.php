<?php\n  use PHPMailer\PHPMailer\PHPMailer;\n  use PHPMailer\PHPMailer\Exception;\n\n  require 'vendor/autoload.php';\n\n  $mail = new PHPMailer(true);\n\n  $mail->isSMTP();\n  $mail->Host = 'smtp.gmail.com';\n  $mail->SMTPAuth = true;\n  $mail->Username = 'your-free-gmail@gmail.com';\n  $mail->Password = 'your-password';\n  $mail->SMTPSecure = 'tls';\n  $mail->Port = 587;\n\n  $mail->setFrom($_POST['email']);\n  $mail->addAddress('your-free-gmail@gmail.com');\n  $mail->Subject = 'Contact Form Submission';\n  $mail->Body = "Name: " . $_POST['name'] . "\r\nEmail: " . $_POST['email'] . "\r\nMessage: " . $_POST['message'];\n\n  try {\n    $mail->send();\n    echo 'Message has been sent';\n  } catch (Exception $e) {\n    echo 'Message could not be sent. Mailer Error: ' . $mail->ErrorInfo;\n  }\n?>