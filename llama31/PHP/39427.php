$host = 'imap.gmail.com'; // or your email provider's IMAP host\n$username = 'your_email_address';\n$password = 'your_email_password';\n\n// Connect to the IMAP server\n$mailbox = imap_open("{{$host}:993/imap/ssl/novalidate-cert}INBOX", $username, $password);\n\n// Search for emails\n$search = imap_search($mailbox, 'ALL');\n\n// Loop through the emails\nforeach ($search as $msgno) {\n    $header = imap_headerinfo($mailbox, $msgno);\n    $structure = imap_fetchstructure($mailbox, $msgno);\n\n    // Check if the email has attachments\n    if (isset($structure->parts)) {\n        foreach ($structure->parts as $part) {\n            if ($part->disposition == 'attachment') {\n                // Fetch the attachment\n                $attachment = imap_fetchbody($mailbox, $msgno, $part->number);\n                // Save the attachment to a file\n                file_put_contents($part->filename, $attachment);\n            }\n        }\n    }\n}\n\n// Close the IMAP connection\nimap_close($mailbox);