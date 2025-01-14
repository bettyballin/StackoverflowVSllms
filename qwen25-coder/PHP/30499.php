<?php\nrequire_once 'Mail/mimeDecode.php';\nrequire_once 'HTTP/MIMEType.php';\n\n/**\n * Function to parse and display email content as HTML.\n * @param string $filePath Path to the raw email file.\n */\nfunction displayEmailAsHtml($filePath) {\n    // Read the contents of the file\n    $fileContents = file_get_contents($filePath);\n    \n    if (!$fileContents) {\n        echo "<p>Failed to read the email file.</p>";\n        return;\n    }\n\n    // Set up options for parsing\n    $params['include_bodies'] = true;\n    $params['decode_bodies']  = true;\n    $params['decode_headers'] = false;\n\n    // Decode the message\n    $decoder = new Mail_mimeDecode($fileContents);\n    $structure = $decoder->decode($params);\n\n    displayPart($structure, '');\n}\n\n/**\n * Recursive function to display different parts of the email.\n * @param object $part The part structure.\n * @param string $boundary Boundary for multipart messages.\n */\nfunction displayPart(&$part, $boundary) {\n    if (!empty($part->ctype_primary) && !empty($part->ctype_secondary)) {\n        // Check for multipart\n        if ($part->ctype_primary == 'multipart') {\n            foreach ($part->parts as $subpart) {\n                displayPart($subpart, "----{$part->boundary}");\n            }\n        } else {\n            // Display content based on type\n            switch ($part->ctype_secondary) {\n                case 'plain':\n                    echo "<div>" . nl2br(htmlentities($part->body)) . "</div>";\n                    break;\n                case 'html':\n                    echo $part->body;\n                    break;\n                default:\n                    // Handle attachments or other content types\n                    if (!empty($part->d_parameters['filename'])) {\n                        $fileName = $part->d_parameters['filename'];\n                        $mimeType = HTTP_MIMEType::byExtension(pathinfo($fileName, PATHINFO_EXTENSION));\n                        echo "<a href='data:$mimeType;base64," . base64_encode($part->body) . "' download='$fileName'>$fileName</a>";\n                    }\n            }\n        }\n    }\n}\n\n// Usage example\ndisplayEmailAsHtml('path/to/your/email.eml');\n?>