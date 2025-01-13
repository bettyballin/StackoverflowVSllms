<?php\nrequire 'vendor/autoload.php';\n\nuse SSilence\ImapClient\ImapClientException;\nuse SSilence\ImapClient\ImapClient;\n\n$host = 'pop3.example.com';\n$port = 110;\n$encryption = false;  // false, 'ssl', or 'tls'\n$mailbox = 'INBOX';\n$username = 'your-email@example.com';\n$password = 'your-password';\n\ntry {\n    // Connect\n    $imap = new ImapClient($host, $username, $password, $port, $encryption, $mailbox);\n\n    // Get folders\n    $folders = $imap->getFolders();\n    print_r($folders);\n\n    // Get emails from the inbox\n    $emails = $imap->getMessages();\n    foreach ($emails as $email) {\n        echo 'Subject: ' . $email->header->subject . "\n";\n        echo 'From: ' . $email->header->from . "\n";\n        echo 'Body: ' . $email->message->text . "\n";\n    }\n\n    // Example: Delete an email\n    // $imap->deleteMessage($emails[0]->uid);\n\n} catch (ImapClientException $error) {\n    echo "IMAP error: " . $error->getMessage() . "\n";\n}\n?>