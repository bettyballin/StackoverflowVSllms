$smtp = 'smtp.example.com';\n$config = [\n    'auth' => 'login',\n    'username' => 'your_username',\n    'password' => 'your_password',\n    'ssl' => 'tls',    // or 'ssl' depending on your SMTP server\n    'port' => 587      // commonly used ports: 25, 465, 587\n];\n\ntry {\n    $tr = new Zend_Mail_Transport_Smtp($smtp, $config);\n    $mail = new Zend_Mail();\n    $mail->setDefaultTransport($tr);\n    $mail->setFrom($from, $from_name);\n    $mail->addTo($one_email);\n    $mail->setSubject($subject);\n    $mail->setBodyText($content);\n    $mail->send($tr);\n} catch (Zend_Mail_Protocol_Exception $e) {\n    echo 'Failed to send email: ', $e->getMessage();\n}