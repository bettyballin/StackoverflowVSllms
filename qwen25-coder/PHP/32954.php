<?php\nrequire_once '/path/to/vendor/autoload.php';\n\nuse \Swift_Message;\nuse \Swift_SmtpTransport;\nuse \Swift_Mailer;\n\n// Create the Transport (replace with your SMTP server details)\n$transport = new Swift_SmtpTransport('smtp.example.org', 25);\n$mailer = new Swift_Mailer($transport);\n\n// Create a message template for sending\n$messageTemplate = (new Swift_Message('Your Subject Here'))\n  ->setBody('<html><body><p>Dear {{name}},<br>Your email body here.</p></body></html>', 'text/html');\n\n$recipients = [\n    ['email' => 'user1@example.com', 'name' => 'User One'],\n    // more recipients...\n];\n\nforeach ($recipients as $recipient) {\n    $message = clone $messageTemplate;\n    $message\n        ->setTo($recipient['email'])\n        ->setSubject('Personalized Subject')\n        ->setBody(str_replace('{{name}}', $recipient['name'], $message->getBody()));\n        \n    // Add the message to a batch\n    $messages[] = $message;\n}\n\n// Send using batchSend method\n$numSent = $mailer->batchSend($messages);\necho "Number of emails sent: " . $numSent;\n?>