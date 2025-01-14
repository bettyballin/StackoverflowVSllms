<?php\nuse PHPMailer\PHPMailer\PHPMailer;\nuse PHPMailer\PHPMailer\Exception;\n\nrequire 'path/to/PHPMailer/src/Exception.php';\nrequire 'path/to/PHPMailer/src/PHPMailer.php';\nrequire 'path/to/PHPMailer/src/SMTP.php';\n\n$mail = new PHPMailer(true);\n\ntry {\n    // FTP settings\n    $ftp_server = "ftp.example.com";\n    $ftp_user_name = "username";\n    $ftp_user_pass = "password";\n\n    // Open a connection to the FTP server\n    $conn_id = ftp_connect($ftp_server) or die("Couldn't connect to $ftp_server");\n\n    // Login with username and password\n    if (!ftp_login($conn_id, $ftp_user_name, $ftp_user_pass)) {\n        die('Could not log in.');\n    }\n\n    // Path on the FTP server\n    $remote_file = '/artwork/14653/16296/Final/Final.pdf';\n\n    // Local path where to save the file\n    $local_file = sys_get_temp_dir() . '/temp_final.pdf';\n\n    // Download the file from FTP server to local directory\n    if (ftp_get($conn_id, $local_file, $remote_file, FTP_BINARY)) {\n        echo "Successfully written to $local_file\n";\n\n        //Server settings\n        $mail->isSMTP();\n        $mail->Host = 'smtp.example.com';\n        $mail->SMTPAuth = true;\n        $mail->Username = 'your-email@example.com';\n        $mail->Password = 'your-email-password';\n        $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;\n        $mail->Port = 587;\n\n        //Recipients\n        $mail->setFrom('from@example.com', 'Mailer');\n        $mail->addAddress('recipient@example.com');\n\n        // Attachments\n        $mail->addAttachment($local_file);\n\n        // Content\n        $mail->isHTML(true);\n        $mail->Subject = 'Here is your artwork';\n        $mail->Body    = '<b>Your requested artwork is attached.</b>';\n\n        $mail->send();\n        echo 'Message has been sent';\n\n        // Unlink the local file after sending email\n        unlink($local_file);\n    } else {\n        die('Error downloading the file.');\n    }\n\n    // Close FTP connection\n    ftp_close($conn_id);\n\n} catch (Exception $e) {\n    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";\n}\n?>