<?php\n\nfunction processEmail($emails) {\n    foreach ($emails as $emailNumber) {\n\n        // Fetch information about the mail\n        $overview = imap_fetch_overview($emails, $emailNumber, 0);\n        \n        // Get the message from email number\n        $message = imap_fetchbody($emails, $emailNumber, '1');\n        \n        // Write message and subject to file for demonstration purposes\n        file_put_contents('data/messages/subject_' . $overview[0]->msgno . '.txt', $overview[0]->subject);\n        file_put_contents('data/messages/messageContent_' . $overview[0]->msgno . '.txt', strip_tags($message));\n        \n        // Get all the structure information\n        $structure = imap_fetchstructure($emails, $emailNumber);\n\n        if (isset($structure->parts) && is_array($structure->parts)) {\n            foreach ($structure->parts as $key => $value) {\n\n                // Check if the part contains an attachment\n                if ((string)$value->disposition === 'ATTACHMENT' OR (isset($value->subtype) and $value->subtype == "octet-stream")) {\n                    $attachment = imap_fetchbody($emails, $emailNumber, $key + 1);\n                    \n                    // Get the filename of the attachment\n                    $fileName = msgpartFilename($structure->parts[$key]);\n                    \n                    if ($fileName) {\n                        $filePath = 'data/attachments/' . $fileName;\n                        \n                        // Decode binary data as string and base64 encode it back so that it can be saved to file\n                        if ($value->encoding == 3) { // 3 = BASE64\n                            $attachment = imap_base64($attachment);\n                        } elseif ($value->encoding == 4) { // 4 = QUOTED-PRINTABLE\n                            $attachment = imap_qprint($attachment);\n                        }\n                        \n                        // Save the attachment to a file\n                        file_put_contents($filePath, $attachment);\n                    }\n                }\n            }\n        }\n    }\n\n    return true;\n}\n\nfunction msgpartFilename($structure){\n    for ($i=0; $i < count($structure->dparameters); $i++) {\n        if (strtolower($structure->dparameters[$i]->attribute) == 'filename') {\n            return $structure->dparameters[$i]->value;\n        }\n    }\n\n    for ($i=0; $i < count($structure->parameters); $i++) {\n        if(strtolower($structure->parameters[$i]->attribute) == 'name'){\n            return $structure->parameters[$i]->value;\n        }\n    }\n\n    return false;\n}\n\n// Set up the mailbox connection\n$mailbox = "{mail.server.com/pop3/novalidate-cert}INBOX";\n\n// Open IMAP stream to mailbox\n$emails = imap_open($mailbox, 'username', 'password');\n\nif ($emails) {\n    // Check for any new messages and read them\n    $emailNumbers = imap_search($emails, 'ALL');\n\n    if ($emailNumbers) {\n        // Sort the email numbers in ascending order\n        rsort($emailNumbers);\n        \n        // Process the emails\n        processEmail($emailNumbers);\n        \n        echo "Done processing emails.\n";\n    } else {\n        echo "No messages found.\n";\n    }\n\n    // Close the IMAP stream when finished\n    imap_close($emails,CL_EXPUNGE);\n} else {\n    die(imap_last_error());\n}\n\n?>