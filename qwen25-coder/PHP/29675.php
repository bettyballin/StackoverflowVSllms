// Import Swift Mailer classes\nrequire_once 'vendor/autoload.php';\n\nuse Swift_Mailer;\nuse Swift_SmtpTransport;\nuse Swift_Message;\n\n// Specify the SMTP server details\n$smtpHost = 'your.smtp.server';  // Replace with your SMTP host\n$smtpPort = 25;                  // Common port for SMTP\n\n// Create an instance of Swift_Transport_Esmtp_Auth_LoginAuthenticator if needed\n$transport = Swift_SmtpTransport::newInstance($smtpHost, $smtpPort)\n    ->setLocalDomain('SERVER_HOSTNAME');  // Set your server's hostname here\n\n// If your SMTP requires authentication\n$username = 'your-smtp-username';\n$password = 'your-smtp-password';\n$transport-> setUsername($username);\n$transport-> setPassword($password);\n\n// Create the Mailer using your created Transport\n$mailer = Swift_Mailer::newInstance($transport);\n\n// Create a message\n$message = Swift_Message::newInstance('Test Email')\n    ->setFrom(array('from@example.com' => 'Your Name'))\n    ->setTo(array('to@example.com' => 'Recipient Name'))\n    ->setBody('This is the body of the email.');\n\n// Send the message\n$result = $mailer->send($message);\n\nif ($result) {\n    echo "Email sent successfully.";\n} else {\n    echo "Failed to send email.";\n}