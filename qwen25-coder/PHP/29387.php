// Define batch size (number of emails per batch)\n$batchSize = 50;\n\n$config = array('ssl' => 'tls', 'port' => 587, 'auth' => 'login', 'username' => 'username', 'password' => 'password');\n$smtpConnection = new Zend_Mail_Transport_Smtp('smtp.gmail.com', $config);\n\nfor ($i = 0; $i < count($subscribers); $i += $batchSize) {\n    $message = new Zend_Mail('utf-8');\n    $message->setFrom('my@mailinglist.com', 'Mailing List')\n            ->setSubject($subject)\n            ->setBodyText($body);\n\n    // Create attachment and stream it\n    $attachment = $message->createAttachment(fopen($filepath, 'r'));\n    $attachment->type = 'application/pdf';\n    $attachment->filename = $filename;\n\n    // Add BCC recipients within the current batch\n    for ($j = $i; $j < min($i + $batchSize, count($subscribers)); ++$j) {\n        $message->addBcc($subscribers[$j]->email);\n    }\n\n    // Send email\n    $message->send($smtpConnection);\n\n    // Clear message recipients to prevent issues in subsequent batches\n    $message->clearRecipients();\n}