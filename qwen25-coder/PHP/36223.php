<?php\n$imapPath = '{imap.domain.com:993/imap/ssl}INBOX';\n$username = 'account@domain.com';\n$password = 'password';\n\n$mailbox = imap_open($imapPath, $username, $password);\n\nif (!$mailbox) {\n    die('Connect failed: ' . imap_last_error());\n}\n\n$emails = imap_search($mailbox, 'ALL');\n$overview = imap_fetch_overview($mailbox, implode(',', $emails), 0);\n$output = '';\n\nforeach ($overview as $email) {\n    $output .= '<div>' .\n               '<strong>Subject:</strong> ' . htmlspecialchars($email->subject) . '<br/>' .\n               '<strong>From:</strong> ' . htmlspecialchars($email->from) . '<br/>' .\n               '<strong>Date:</strong> ' . htmlspecialchars($email->date) . '<br/>';\n    \n    $message = imap_fetchbody($mailbox, $email->msgno, 1);\n    if ($message !== '') {\n        $output .= '<p><strong>Message:</strong> ' . nl2br(htmlspecialchars(imap_qprint($message))) . '</p>';\n    }\n    \n    // Check for attachments\n    $structure = imap_fetchstructure($mailbox, $email->msgno);\n    if (isset($structure->parts)) {\n        foreach ($structure->parts as $part) {\n            if ($part->disposition == 'attachment') {\n                $filename = $part->dparameters[0]->value;\n                $attachmentData = imap_fetchbody($mailbox, $email->msgno, $part->part_number);\n                $decodedAttachment = imap_base64($attachmentData);\n                \n                // Handle the attachment data (e.g., save to file, display link)\n                file_put_contents('/path/to/attachments/' . $filename, $decodedAttachment);\n                $output .= '<p><strong>Attachment:</strong> <a href="attachments/' . htmlspecialchars($filename) . '">' . htmlspecialchars($filename) . '</a></p>';\n            }\n        }\n    }\n    \n    $output .= '</div><hr/>';\n}\n\necho $output;\n\nimap_close($mailbox);\n?>