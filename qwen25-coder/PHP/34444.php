$config = array('ssl' => 'tls', 'port' => 587, 'auth' => 'login', 'username' => 'webmaster@mydomain.com', 'password' => 'your-google-apps-password');\n$smtpConnection = new Zend_Mail_Transport_Smtp('smtp-relay.gmail.com', $config);\n\n$mail = new Zend_Mail();\n$mail->setBodyText('This is the text of the email.');\n$mail->setFrom('webmaster@mydomain.com', 'Some Sender');\n$mail->addTo('recipient@example.com', 'Recipient Name');\n$mail->setSubject('Test Subject');\n\ntry {\n    $mail->send($smtpConnection);\n} catch (Exception $e) {\n    echo "Sending mail caused an exception: " . $e->getMessage();\n}