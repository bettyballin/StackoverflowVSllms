<?php\nuse PHPMailer\PHPMailer\PHPMailer;\nuse PHPMailer\PHPMailer\Exception;\n\nrequire 'path/to/PHPMailer/src/Exception.php';\nrequire 'path/to/PHPMailer/src/PHPMailer.php';\n\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $name = filter_var(trim($_POST['name']), FILTER_SANITIZE_STRING);\n    $email = filter_var(trim($_POST['email']), FILTER_VALIDATE_EMAIL);\n    $subject = filter_var(trim($_POST['subject']), FILTER_SANITIZE_STRING);\n    $body = filter_var(trim($_POST['body']), FILTER_SANITIZE_STRING);\n\n    if ($email) {\n        $mail = new PHPMailer(true);\n\n        try {\n            $mail->setFrom($email, $name);\n            $mail->addAddress('your-email@example.com', 'Your Name');\n\n            $mail->isHTML(false);\n            $mail->Subject = $subject;\n            $mail->Body    = $body;\n\n            $mail->send();\n            echo "Email sent successfully!";\n        } catch (Exception $e) {\n            echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";\n        }\n    } else {\n        echo "Invalid email address.";\n    }\n}\n?>