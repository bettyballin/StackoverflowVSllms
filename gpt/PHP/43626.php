<?php\n// Define mailbox and login credentials\n$mailbox = '{imap.example.com:993/imap/ssl}INBOX'; // Replace with your IMAP server details\n$username = 'your_email@example.com'; // Replace with your email\n$password = 'your_password'; // Replace with your email password\n\n// Connect to the mailbox\n$inbox = imap_open($mailbox, $username, $password) or die('Cannot connect to mailbox: ' . imap_last_error());\n\n// Fetch emails\n$emails = imap_search($inbox, 'ALL');\n\nif ($emails) {\n    rsort($emails); // Sort emails from newest to oldest\n\n    foreach ($emails as $email_number) {\n        $overview = imap_fetch_overview($inbox, $email_number, 0);\n        $message = imap_fetchbody($inbox, $email_number, 2);\n        \n        $structure = imap_fetchstructure($inbox, $email_number);\n        $attachments = [];\n\n        if (isset($structure->parts) && count($structure->parts)) {\n            for ($i = 0; $i < count($structure->parts); $i++) {\n                $attachment = $structure->parts[$i];\n\n                if ($attachment->ifdparameters) {\n                    foreach ($attachment->dparameters as $object) {\n                        if (strtolower($object->attribute) == 'filename') {\n                            $attachments[$i]['is_attachment'] = true;\n                            $attachments[$i]['filename'] = $object->value;\n                        }\n                    }\n                }\n\n                if ($attachment->ifparameters) {\n                    foreach ($attachment->parameters as $object) {\n                        if (strtolower($object->attribute) == 'name') {\n                            $attachments[$i]['is_attachment'] = true;\n                            $attachments[$i]['name'] = $object->value;\n                        }\n                    }\n                }\n\n                if ($attachments[$i]['is_attachment']) {\n                    $attachments[$i]['attachment'] = imap_fetchbody($inbox, $email_number, $i+1);\n\n                    // Decode the attachment\n                    if ($attachment->encoding == 3) { // 3 = BASE64\n                        $attachments[$i]['attachment'] = base64_decode($attachments[$i]['attachment']);\n                    }\n                    elseif ($attachment->encoding == 4) { // 4 = QUOTED-PRINTABLE\n                        $attachments[$i]['attachment'] = quoted_printable_decode($attachments[$i]['attachment']);\n                    }\n                }\n            }\n        }\n\n        // Save attachments\n        foreach ($attachments as $attachment) {\n            if ($attachment['is_attachment']) {\n                $filename = $attachment['filename'] ? $attachment['filename'] : $attachment['name'];\n                $fp = fopen('./attachments/' . $filename, 'w+'); // Save to "attachments" directory\n                fwrite($fp, $attachment['attachment']);\n                fclose($fp);\n            }\n        }\n    }\n}\n\n// Close the connection\nimap_close($inbox);\n?>