<?php\n// Server Configuration\n$hostname = '{imap.myserver.com:993/imap/ssl}INBOX';\n\n// Access credentials for your email account\n$username = 'your_email@example.com';\n$password = 'your_password';\n\n// Connect to the server and open the mail box\n$inbox = imap_open($hostname, $username, $password) or die('Cannot connect to Mail: ' . imap_last_error());\n\n// Fetch all emails from the inbox\n$mbox = imap_search($inbox, 'ALL');\n\nif ($mbox === false) {\n    echo "Mailbox is empty";\n} else {\n    rsort($mbox); // Sort emails highest number first (newest first)\n\n    foreach ($mbox as $email_number) {\n        $overview = imap_fetch_overview($inbox, $email_number, 0);\n        $message = imap_fetchbody($inbox, $email_number, '1');\n\n        // Process the email content here\n        echo "Subject: " . $overview[0]->subject . "\n";\n        echo "From: " . $overview[0]->from . "\n";\n        echo "Message: " . $message . "\n";\n\n        // Optionally delete or move the email after processing\n        imap_delete($inbox, $email_number);\n    }\n\n    // Delete all flags that were set using imap_delete()\n    imap_expunge($inbox);\n}\n\n// Close the mail box\nimap_close($inbox);\n?>