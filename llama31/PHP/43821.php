require_once 'PHPMailerAutoload.php';\n\n$email = 'user@example.com';\n$mailer = new PHPMailer();\nif ($mailer->validateAddress($email)) {\n    echo "$email is valid";\n} else {\n    echo "$email is not valid";\n}