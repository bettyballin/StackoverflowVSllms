require_once 'PHPMailerAutoload.php';\n\nfunction mail($to, $subject, $message, $headers = '', $attachments = '') {\n  $mail = new PHPMailer;\n  $mail->isSMTP();\n  $mail->Host = 'your_smtp_host';\n  $mail->SMTPAuth = true;\n  $mail->Username = 'your_smtp_username';\n  $mail->Password = 'your_smtp_password';\n  $mail->SMTPSecure = 'tls';\n  $mail->Port = 587;\n\n  $mail->setFrom('your_from_email', 'Your Name');\n  $mail->addAddress($to);\n\n  $mail->Subject = $subject;\n  $mail->Body = $message;\n\n  if (!$mail->send()) {\n    return false;\n  } else {\n    return true;\n  }\n}